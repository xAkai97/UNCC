using UnityEngine;
using System.Collections.Generic;

public class LeaderController : MonoBehaviour
{
    public float maxSpeed = 5f;
    public float satisfactionRadius = 0.5f;
    public float smoothTurnSpeed = 5f;
    public float movementSpeed = 3f;

    private List<Vector2> path;
    private int currentPathIndex;
    private bool isMoving = false;
    private Pathfinding pathfinding;

    private Vector2 startPos;
    private Vector2 endPos;

    public void SetPath(List<Vector2> newPath)
    {
        path = newPath;
        currentPathIndex = 0;
        isMoving = true;
    }

    void Start()
    {
        pathfinding = FindObjectOfType<Pathfinding>();
    }

    void Update()
    {
        if (isMoving)
        {
            MoveLeader();
        }

        // Update startPos and endPos
        startPos = transform.position;
        if (path != null && path.Count > 0)
        {
            endPos = path[path.Count - 1];
        }
    }

    void MoveLeader()
    {
        if (path == null || currentPathIndex >= path.Count)
        {
            isMoving = false;
            Debug.Log("Movement stopped: Path is null or currentPathIndex exceeds path count.");
            return;
        }

        Vector2 currentPosition = transform.position;
        Vector2 targetPosition = path[currentPathIndex];
        Vector2 directionToTarget = targetPosition - currentPosition;
        float distanceToTarget = directionToTarget.magnitude;

        if (distanceToTarget > satisfactionRadius)
        {
            directionToTarget.Normalize();

            // Apply smooth rotation to face the movement direction
            float angle = Mathf.Atan2(directionToTarget.y, directionToTarget.x) * Mathf.Rad2Deg;
            Quaternion targetRotation = Quaternion.Euler(0, 0, angle - 90);
            transform.rotation = Quaternion.Slerp(transform.rotation, targetRotation, Time.deltaTime * smoothTurnSpeed);

            // Move the leader with adjusted speed for diagonal movement
            float adjustedSpeed = movementSpeed * (directionToTarget.x != 0 && directionToTarget.y != 0 ? 0.7071f : 1f); // 1/sqrt(2) for diagonals
            Vector3 newPosition = transform.position + (Vector3)(directionToTarget * adjustedSpeed * Time.deltaTime);
            newPosition.x = Mathf.Clamp(newPosition.x, 0, pathfinding.GridWidth - 1);
            newPosition.y = Mathf.Clamp(newPosition.y, 0, pathfinding.GridHeight - 1);
            newPosition.z = 0; // Ensure the z-coordinate is set to 0
            transform.position = newPosition;

            Debug.Log($"Moving to {targetPosition}, current position: {currentPosition}, new position: {newPosition}");
        }
        else
        {
            currentPathIndex++;
            Debug.Log($"Reached target position: {targetPosition}, moving to next path index: {currentPathIndex}");
            if (currentPathIndex >= path.Count)
            {
                isMoving = false; // Stop moving if the end of the path is reached
                path = null; // Clear the path
                Debug.Log("Reached end of path, stopping movement.");
            }
        }
    }
}