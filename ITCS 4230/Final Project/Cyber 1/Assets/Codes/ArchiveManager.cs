using System;
using System.Collections;
using System.Collections.Generic;
using UnityEditor.Experimental.GraphView;
using UnityEngine;

namespace CyberSpace
{
    public class ArchiveManager : MonoBehaviour
    {
        public GameObject[] lockCharacter;
        public GameObject[] unlockCharacter;
        public GameObject uiNotice;

        enum Archive { UnlockAndriodM, UnlockAndriodF }
        Archive[] archives;
        WaitForSecondsRealtime wait;

        void Awake()
        {
            archives = (Archive[])Enum.GetValues(typeof(Archive));
            wait = new WaitForSecondsRealtime(5);

            if (!PlayerPrefs.HasKey("MyData")) {
                Init();
            }
        }

        void Init()
        {
            PlayerPrefs.SetInt("MyData", 1);

            foreach (Archive archive in archives) {
                PlayerPrefs.SetInt(archive.ToString(), 0);
            }
        }

        void Start()
        {
            UnlockCharacter();
        }

        void UnlockCharacter()
        {
            for (int index = 0; index < lockCharacter.Length; index++) {
                string archiveName = archives[index].ToString();
                bool isUnlock = PlayerPrefs.GetInt(archiveName) == 1;
                lockCharacter[index].SetActive(!isUnlock);
                unlockCharacter[index].SetActive(isUnlock);
            }
        }

        void LateUpdate()
        {
            foreach (Archive archive in archives) {
                CheckArchive(archive);
            }
        }

        void CheckArchive(Archive archive)
        {
            bool isArchive = false;

            switch (archive) {
                case Archive.UnlockAndriodM:
                    if (PlayerPrefs.GetInt("TotalKills") >= 10)
                        isArchive = PlayerPrefs.GetInt("TotalKills") >= 10;
                    break;
                case Archive.UnlockAndriodF:
                    if (PlayerPrefs.GetInt("TotalKills") >= 20)
                        isArchive = PlayerPrefs.GetInt("TotalKills") >= 20;
                    break;
            }

            if (isArchive && PlayerPrefs.GetInt(archive.ToString()) == 0) {
                PlayerPrefs.SetInt(archive.ToString(), 1);

                for (int index = 0; index < uiNotice.transform.childCount; index++) {
                    bool isActive = index == (int)archive;
                    uiNotice.transform.GetChild(index).gameObject.SetActive(isActive);
                }

                StartCoroutine(NoticeRoutine());
            }
        }

        IEnumerator NoticeRoutine()
        {
            uiNotice.SetActive(true);
            AudioManager.instance.PlaySfx(AudioManager.Sfx.LevelUp);

            yield return wait;

            uiNotice.SetActive(false);
        }
    }
}
