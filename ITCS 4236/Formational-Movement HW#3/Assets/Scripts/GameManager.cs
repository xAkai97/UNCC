using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class GameManager2D : MonoBehaviour
{
    public Transform formation;
    public GameObject obstaclePrefab;
    public float obstacleSize = 1f;

    private Pathfinding pathfinding;

    // Relative positions for characters in a "finger-four" formation.
    private Vector2[] formationOffsets = new Vector2[]
    {
        new Vector2(0, 0),    // Leader
        new Vector2(-2, -2),  // Second Row Left (Increased from -1, -1)
        new Vector2(2, -2),   // Second Row Right (Increased from 1, -1)
        new Vector2(4, -4)    // Trailing, further to the right of Character 2
    };

    void Start()
    {
        pathfinding = FindObjectOfType<Pathfinding>();
        if (pathfinding != null)
        {
            pathfinding.GenerateGrid();
        }
    }

    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            StartPathfinding();
        }
        else if (Input.GetMouseButtonDown(1))
        {
            CreateObstacle();
        }
    }

    void StartPathfinding()
    {
        Vector2 leaderDestination = GetMouseWorldPosition();
        Vector2 leaderPosition = formation.GetChild(0).position;
        Debug.Log($"Leader Position: {leaderPosition}");

        // Round leaderPosition to align with grid cells
        leaderPosition = new Vector2(Mathf.Round(leaderPosition.x), Mathf.Round(leaderPosition.y));

        // Clamp the leader position to ensure it stays within the grid bounds
        leaderPosition = ClampPositionToGridBounds(leaderPosition);
        leaderDestination = ClampPositionToGridBounds(leaderDestination);
        Debug.Log($"Clamped Leader Destination: {leaderDestination}");

        if (pathfinding != null)
        {
            pathfinding.SetPathPositions(leaderPosition, leaderDestination);
        }

        if (pathfinding.GetFinalPath() == null)
        {
            Debug.Log("No valid path found");
            return;
        }

        // Restart pathfinding process
        StopAllCoroutines();
        StartCoroutine(WaitForPathfinding());
    }

    Vector2 ClampPositionToGridBounds(Vector2 position)
    {
        float clampedX = Mathf.Clamp(position.x, 0, pathfinding.GridWidth * pathfinding.CellSize.x - 1);
        float clampedY = Mathf.Clamp(position.y, 0, pathfinding.GridHeight * pathfinding.CellSize.y - 1);
        return new Vector2(clampedX, clampedY);
    }

    private IEnumerator WaitForPathfinding()
    {
        yield return new WaitUntil(() => pathfinding.GetFinalPath() != null);

        MoveLeader();
        MoveFormation();
    }

    void MoveLeader()
    {
        List<Vector2> finalPath = pathfinding.GetFinalPath();

        if (finalPath == null || finalPath.Count == 0)
        {
            Debug.Log("No valid path for formation to follow");
            return;
        }

        LeaderController leaderController = formation.GetChild(0).GetComponent<LeaderController>();
        if (leaderController != null)
        {
            leaderController.SetPath(finalPath);
        }
    }

    void MoveFormation()
    {
        // Get the leader's position from the LeaderController
        LeaderController leaderController = formation.GetChild(0).GetComponent<LeaderController>();
        if (leaderController == null)
        {
            Debug.LogError("LeaderController not found on the leader.");
            return;
        }

        Vector2 leaderPosition = leaderController.transform.position;
        Vector2 leaderDestination = GetMouseWorldPosition();
        Vector2 movementDirection = (leaderDestination - leaderPosition).normalized;

        // Calculate the angle needed to align the leader's direction.
        float angle = Mathf.Atan2(movementDirection.y, movementDirection.x) * Mathf.Rad2Deg;

        int i = 0; // Index for iterating formation offsets.
        foreach (Transform child in formation)
        {
            if (i == 0)
            {
                // Skip the leader as it is controlled by the LeaderController
                i++;
                continue;
            }

            CharacterController2D controller = child.GetComponent<CharacterController2D>();
            if (controller != null)
            {
                // Rotate formation offsets to align with the leader's movement direction.
                Vector2 rotatedOffset = RotateOffset(formationOffsets[i], angle - 90); // Adjust by -90 to account for the default downward-facing alignment.
                controller.SetDestination(leaderDestination, rotatedOffset);
                i++;
            }
        }
    }

    // Helper function to rotate a vector by a specified angle in degrees.
    Vector2 RotateOffset(Vector2 offset, float angle)
    {
        float radians = angle * Mathf.Deg2Rad; // Convert angle to radians for trigonometric functions.
        float cos = Mathf.Cos(radians);
        float sin = Mathf.Sin(radians);
        return new Vector2(
            offset.x * cos - offset.y * sin,
            offset.x * sin + offset.y * cos
        );
    }

    void CreateObstacle()
    {
        Vector2 spawnPosition = GetMouseWorldPosition();
        Instantiate(obstaclePrefab, spawnPosition, Quaternion.identity)
            .transform.localScale = Vector3.one * obstacleSize;
    }

    Vector2 GetMouseWorldPosition()
    {
        Vector3 worldPosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);
        worldPosition.z = 0; // Ensure the z-coordinate is set to 0
        Vector2 mouseWorldPosition = new Vector2(Mathf.Round(worldPosition.x), Mathf.Round(worldPosition.y));
        Debug.Log($"Mouse World Position: {mouseWorldPosition}");
        return mouseWorldPosition;
    }
}
