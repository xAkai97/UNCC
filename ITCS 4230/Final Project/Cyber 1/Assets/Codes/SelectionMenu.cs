using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.SocialPlatforms.Impl;

namespace CyberSpace
{
    public class SelectionMenu : MonoBehaviour
    {			
		public int totalKills;
            
		void Awake()
        {
			totalKills = totalKills + PlayerPrefs.GetInt("Kills");
		}
            
		public void StartGame()
		{
			SceneManager.LoadSceneAsync(2);
		}
		
		public void SaveGame(int id)
		{
			PlayerPrefs.SetInt("PlayerID", id);
			PlayerPrefs.SetInt("TotalKills", totalKills);
		}
		
		public void ReturnToMenu()
		{
			SceneManager.LoadSceneAsync(0);
		}
    }
}
