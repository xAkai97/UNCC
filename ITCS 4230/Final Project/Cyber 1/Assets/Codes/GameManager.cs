using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

namespace CyberSpace
{
    public class GameManager : MonoBehaviour
    {
        public static GameManager instance;

        [Header("# Game Control")]
		public bool isLive;
        public float gameTime;
        public float maxGameTime = 2 * 10f;
        [Header("# Player Info")]
		public int playerId;
        public float health;
        public float maxHealth = 100;
        public int level;
        public int kill;
        public int exp;
        public int[] nextExp = { 3, 5, 10, 100, 150, 210, 280, 360, 450, 600 };
        [Header("# Game Object")]
        public PoolManager pool;
        public Player player;
        public LevelUp uiLevelUp;
        public Result uiResult;
        public GameObject enemyCleaner;
        
        

        void Awake()
        {
            instance = this;
            Application.targetFrameRate = 60;
        }
        public void LoadSave()
        {
            playerId = PlayerPrefs.GetInt("PlayerID");
        }

        public void GameStart()
        {
            health = maxHealth;

            player.gameObject.SetActive(true);
            uiLevelUp.Select(playerId % 2);
            Resume();

            AudioManager.instance.PlayBgm(true);
            AudioManager.instance.PlaySfx(AudioManager.Sfx.Select);
        }

        public void GameOver()
        {
			PlayerPrefs.SetInt("Kills", GameManager.instance.kill);
            StartCoroutine(GameOverRoutine());
        }

        IEnumerator GameOverRoutine()
        {
            GameManager.instance.isLive = false;

            yield return new WaitForSeconds(0.5f);

            uiResult.gameObject.SetActive(true);
            uiResult.Lose();
            Stop();

            AudioManager.instance.PlayBgm(false);
            AudioManager.instance.PlaySfx(AudioManager.Sfx.Lose);
        }

        public void GameVictroy()
        {
            PlayerPrefs.SetInt("Kills", GameManager.instance.kill);
            StartCoroutine(GameVictroyRoutine());
        }

        IEnumerator GameVictroyRoutine()
        {
            GameManager.instance.isLive = false;
            enemyCleaner.SetActive(true);

            yield return new WaitForSeconds(0.5f);

            uiResult.gameObject.SetActive(true);
            uiResult.Win();
            Stop();

            AudioManager.instance.PlayBgm(false);
            AudioManager.instance.PlaySfx(AudioManager.Sfx.Win);
        }

        public void GameRetry()
        {
            SceneManager.LoadScene(1);
        }

        public void GameQuit()
        {
            Application.Quit();
        }

        void Update()
        {
            if (!GameManager.instance.isLive)
                return;

            gameTime += Time.deltaTime;

            if (gameTime > maxGameTime) {
                gameTime = maxGameTime;
                GameVictroy();
            }
        }

        public void GetExp()
        {
            if (!GameManager.instance.isLive)
                return;

            exp++;

            if (exp == nextExp[Mathf.Min(level, nextExp.Length - 1)]) {
                level++;
                exp = 0;
                uiLevelUp.Show();
            }
        }

        public void Stop()
        {
            GameManager.instance.isLive = false;
            Time.timeScale = 0;
        }

        public void Resume()
        {
            GameManager.instance.isLive = true;
            Time.timeScale = 1;
        }
    }
}
