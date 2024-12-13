using UnityEngine;

public class GameManager2D : MonoBehaviour
{
    public Transform formation; // Parent object containing all characters in the formation.
    public GameObject obstaclePrefab; // Prefab to be used for dynamically creating obstacles.
    public float obstacleSize = 1f; // Uniform size of the obstacles created.

    // Relative positions for characters in a "finger-four" formation.
    private Vector2[] formationOffsets = new Vector2[]
    {
        new Vector2(0, 0),    // Leader
        new Vector2(-2, -2),  // Second Row Left (Increased from -1, -1)
        new Vector2(2, -2),   // Second Row Right (Increased from 1, -1)
        new Vector2(4, -4)    // Trailing, further to the right of Character 2
    };

    void Update()
    {
        // Detect left mouse click to move the formation.
        if (Input.GetMouseButtonDown(0)) 
        {
            MoveFormation();
        }
        // Detect right mouse click to place an obstacle.
        else if (Input.GetMouseButtonDown(1)) 
        {
            CreateObstacle();
        }
    }

    void MoveFormation()
    {
        // Get the world position from mouse click for the leader to move towards.
        Vector2 leaderDestination = GetMouseWorldPosition();
        Vector2 leaderPosition = formation.GetChild(0).position; // Assume the leader is the first child.
        Vector2 movementDirection = (leaderDestination - leaderPosition).normalized;

        // Calculate the angle needed to align the leader's direction.
        float angle = Mathf.Atan2(movementDirection.y, movementDirection.x) * Mathf.Rad2Deg;

        int i = 0; // Index for iterating formation offsets.
        foreach (Transform child in formation)
        {
            CharacterController2D controller = child.GetComponent<CharacterController2D>();
            if (controller != null && i < formationOffsets.Length)
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
        // Instantiate an obstacle at the mouse click position.
        Vector2 spawnPosition = GetMouseWorldPosition();
        Instantiate(obstaclePrefab, spawnPosition, Quaternion.identity)
            .transform.localScale = Vector3.one * obstacleSize; // Adjust the scale based on `obstacleSize`.
    }

    Vector2 GetMouseWorldPosition()
    {
        // Convert the screen position of the mouse to a world position in the game.
        Vector3 worldPosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);
        return new Vector2(worldPosition.x, worldPosition.y);
    }
}
