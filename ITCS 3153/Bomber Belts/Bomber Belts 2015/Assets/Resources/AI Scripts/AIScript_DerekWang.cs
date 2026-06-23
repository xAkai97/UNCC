using UnityEngine;
using System.Collections;
using System;


public class AIScript_DerekWang : MonoBehaviour {

    public CharacterScript mainScript;

    public float[] buttonCooldowns;
    public float playerSpeed;
    public int[] beltDirections;
    public float[] buttonLocations;
    public int targetBeltIndex = 0;

    /* Code Functions
    - void moveUp() - Moves the player up. The player will continue to move up until otherwise instructed.

    - void moveDown() - Moves the player down. The player will continue to move down until otherwise instructed.

    - void push() -- Attempts to push the closest button. If the character is too far from the button, the button is already engaged, or is on cooldown, nothing will happen.

    - float getCharacterLocation() - Returns the position of the character as a float.

    - float getOpponentLocation() - Returns the position of the opposing character as a float.

    - float[] getButtonLocations() - Returns an array of floats for representing the position of each button on your side.

    - float[] getButtonCooldowns() - Returns an array of floats representing the time remaining before each button may be pressed again.

    - bool[] getBeltDirection() - Returns an array of Boolean values that corresponds to whether or not the buttons on your side of the board have been engaged. 
        True means the belt/button is engaged and the bomb is moving towards your opponent.

    - float[] getBombDistances() - Returns an array of float values that represent the distance each bomb is from its corresponding button on your side.

    - float getPlayerSpeed() - Returns the speed at which the characters move.

    - float getBombSpeed() - Returns the speed at which the bombs move.
    End of Code Functions */

	// Use this for initialization
	void Start () {
        mainScript = GetComponent<CharacterScript>();

        if (mainScript == null)
        {
            print("No CharacterScript found on " + gameObject.name);
            this.enabled = false;
        }

        buttonLocations = mainScript.getButtonLocations();

        playerSpeed = mainScript.getPlayerSpeed();
	}

	// Update is called once per frame
	void Update () {
        float opponentLocation = mainScript.getOpponentLocation();
        float characterLocation = mainScript.getCharacterLocation();
        float targetButtonLocation = buttonLocations[targetBeltIndex];
        
        //Your AI code goes here
        FindNearestButton();
        if (characterLocation > opponentLocation) { 
            MoveCharacter();
        } else {
            OpponentNearMove();
        }
        
    }

    void FindNearestButton() {
        buttonCooldowns = mainScript.getButtonCooldowns();
        beltDirections = mainScript.getBeltDirections();

        float minDistance = 1000;
        int minIndex = 0;
        float distance;

        for (int i = 0; i < beltDirections.Length; i++) {
            distance = Mathf.Abs(buttonLocations[i] - mainScript.getCharacterLocation());

            if (buttonCooldowns[i] <= 0 && (beltDirections[i] == -1 || beltDirections[i] == 0)) {
                if (distance < minDistance) {
                    minIndex = i;
                    minDistance = distance;
                }
            }
        }
        targetBeltIndex = minIndex;
    }

    void MoveCharacter() {
        float characterLocation = mainScript.getCharacterLocation();
        float targetButtonLocation = buttonLocations[targetBeltIndex];

        if (targetButtonLocation < characterLocation) {
            mainScript.push();
            mainScript.moveDown();
            mainScript.push();
        } else {
            mainScript.push();
            mainScript.moveUp();
            mainScript.push();
        }
    }

    void OpponentNearMove() { 
        float characterLocation = mainScript.getCharacterLocation();
        float targetButtonLocation = buttonLocations[targetBeltIndex];

        if (targetButtonLocation < characterLocation) {
            mainScript.moveDown();
            mainScript.push();
            mainScript.moveDown();
            mainScript.push();
        } else {
            mainScript.moveUp();
            mainScript.push();
            mainScript.moveUp();
            mainScript.push();
        }
    }
}
