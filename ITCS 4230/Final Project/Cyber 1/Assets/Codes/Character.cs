using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace CyberSpace
{
    public class Character : MonoBehaviour
    {
        public static float Speed
        {
            get { return PlayerPrefs.GetInt("PlayerID") == 0 ? 1.1f : 1f; }
        }

        public static float WeaponSpeed
        {
            get { return PlayerPrefs.GetInt("PlayerID") == 1 ? 1.1f : 1f; }
        }

        public static float WeaponRate
        {
            get { return PlayerPrefs.GetInt("PlayerID") == 1 ? 0.9f : 1f; }
        }

        public static float Damage
        {
            get { return PlayerPrefs.GetInt("PlayerID") == 2 ? 1.2f : 1f; }
        }

        public static int Count
        {
            get { return PlayerPrefs.GetInt("PlayerID") == 3 ? 1 : 0; }
        }
    }
}
