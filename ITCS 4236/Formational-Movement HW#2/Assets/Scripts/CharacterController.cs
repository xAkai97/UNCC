using UnityEngine;

public class CharacterController2D : MonoBehaviour
{
    public float maxSpeed = 5f; // Maximum normal movement speed
    public float satisfactionRadius = 0.5f; // Radius to consider "arrived"
    public float avoidRadius = 3f; // Radius to detect and avoid obstacles
    public float smoothTurnSpeed = 5f; // Speed for smooth rotation
    public float movementSpeed = 3f; // Base speed for movement
    public float obstacleAvoidanceStrength = 1.5f; // Strength of the avoidance force

    private Vector2 destination; // The target position for the character
    private bool isMoving = false; // Indicates whether the character is currently moving

    public void SetDestination(Vector2 leaderDestination, Vector2 offset)
    {
        // Calculate the character's destination based on the leader's destination and offset
        destination = leaderDestination + offset;
        isMoving = true;
    }

    void Update()
    {
        if (isMoving)
        {
            MoveCharacter();
        }
    }

    void MoveCharacter()
    {
        Vector2 currentPosition = transform.position; // Current position of the character
        Vector2 directionToDestination = destination - currentPosition; // Vector toward the destination
        float distanceToDestination = directionToDestination.magnitude; // Distance to the destination

        if (distanceToDestination > satisfactionRadius)
        {
            directionToDestination = directionToDestination.normalized; // Normalize the direction vector

            // Detect nearby obstacles
            Vector2 avoidanceForce = Vector2.zero; // Initialize avoidance force
            Collider2D[] nearbyObstacles = Physics2D.OverlapCircleAll(currentPosition, avoidRadius);
            foreach (Collider2D obstacle in nearbyObstacles)
            {
                if (obstacle.CompareTag("Obstacle"))
                {
                    // Calculate repulsion force based on the obstacle's position
                    Vector2 obstacleDirection = currentPosition - (Vector2)obstacle.transform.position;
                    float obstacleDistance = obstacleDirection.magnitude;

                    // Scale the avoidance force inversely to the distance
                    float avoidanceStrength = Mathf.Clamp01(1 - (obstacleDistance / avoidRadius));
                    avoidanceForce += obstacleDirection.normalized * avoidanceStrength * obstacleAvoidanceStrength;
                }
            }

            // Combine the direction to destination with the avoidance force
            Vector2 finalDirection = directionToDestination + avoidanceForce;
            finalDirection = finalDirection.normalized; // Normalize the final direction

            // Apply smooth rotation to face the movement direction
            float angle = Mathf.Atan2(finalDirection.y, finalDirection.x) * Mathf.Rad2Deg;
            Quaternion targetRotation = Quaternion.Euler(0, 0, angle - 90); // Adjust by -90 for sprite alignment
            transform.rotation = Quaternion.Slerp(transform.rotation, targetRotation, Time.deltaTime * smoothTurnSpeed);

            // Move the character
            transform.position += (Vector3)(finalDirection * movementSpeed * Time.deltaTime);
        }
        else
        {
            isMoving = false; // Stop moving if within satisfaction radius
        }
    }
}
