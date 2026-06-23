/*
 @file: pthreads_p1.cpp
 
 @author: Derek Wang
 */

#include <pthread.h>
#include <iostream>

using namespace std;

const char* my_messages[4] = {"Italian: Ciao!",  "English: Hello!", "Hindi: Namaste!",  "Spanish: Hola!" };

void *printMessage(void *arg)
{
    int index = *(int*)arg;
    cout << my_messages[index] << endl;
    return NULL;
}

int main()
{
   // id is used to store a unique thread identifier,
   // returned by the call to create a new POSIX thread
   pthread_t id;

   // rc is used to store the code returned by the
   // call to create a new POSIX thread. The value is
   // zero (0) if the call succeeds.
   int rc;
   
   // TODO: Add code to perform any needed initialization
   //       or to process user input

   // Create thread(s)
   // TODO: Modify according to assignment requirements
    for (int i = 0; i < 4; i++) {
        rc = pthread_create(&id, NULL, printMessage, (void*)&i);
        if (rc){
            cout << "ERROR; return code from pthread_create() is " << rc << endl;
            return -1;
        }
    }

   // NOTE: Using exit here will immediately end execution of all threads
   pthread_exit(0);
}
