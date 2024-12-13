// Author: Derek Wang
// Email: dwang26@charlotte.edu
// Description: Homework #1 - Kinematic Arrive

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KinematicArrive : MonoBehaviour
{
    public Transform target; // Target position (set dynamically based on clicks)
    public float maxSpeed = 5f; // Maximum speed of the character
    public float radius = 0.5f; // Satisfaction radius (how close to stop to the target)
    public float timeToTarget = 0.25f; // Time to target (smoothness of movement)

    public LayerMask groundLayer; 
    public Transform groundCheck;
    public float groundCheckRadius = 0.1f;
    public float slopeAngleThreshold = 50f;

    private bool isGrounded;
    private Vector2 velocity;
    private Vector2 targetPosition;
    private bool isMoving = false;

    private Rigidbody2D rb;
    private SpriteRenderer spriteRenderer;

    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        spriteRenderer = GetComponent<SpriteRenderer>();
    }

    void Update()
    {
        isGrounded = Physics2D.OverlapCircle(groundCheck.position, groundCheckRadius, groundLayer);

        // Get the mouse click position in the world and set it as the target
        if (Input.GetMouseButtonDown(0) && isGrounded)
        {
            Vector3 mousePosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);
            targetPosition = new Vector2(mousePosition.x, mousePosition.y); // Set targetPosition instead of modifying target directly
            isMoving = true; // Start moving toward the new target
        }

        // Only call the Arrive method if moving and grounded
        if (isMoving)
        {
            KinematicSteeringOutput steering = GetSteering();
            ApplySteering(steering);
        }
    }

    KinematicSteeringOutput GetSteering()
    {
        KinematicSteeringOutput steering = new KinematicSteeringOutput();

        // Get the direction to the target
        steering.velocity = targetPosition - (Vector2)transform.position;

        // Check if we're within radius
        if (steering.velocity.magnitude < radius)
        {
            return null;
        }

        // Move to our target, timeToTarget seconds
        steering.velocity /= timeToTarget;

        if (steering.velocity.magnitude > maxSpeed)
        {
            steering.velocity.Normalize();
            steering.velocity *= maxSpeed;
        }

        // Flip the sprite based on movement direction
        if (steering.velocity.x > 0)
        {
            spriteRenderer.flipX = false;
        }
        else if (steering.velocity.x < 0)
        {
            spriteRenderer.flipX = true;
        }

        // Output the steering
        steering.rotation = 0;
        return steering;
    }

    void ApplySteering(KinematicSteeringOutput steering)
    {
        if (steering == null)
            return;

        // Update the character's velocity
        rb.velocity = new Vector2(steering.velocity.x, rb.velocity.y); // Preserve the Y velocity (gravity)
    }
}

// Class to hold the steering output data
public class KinematicSteeringOutput
{
    public Vector2 velocity;
    public float rotation;
}
