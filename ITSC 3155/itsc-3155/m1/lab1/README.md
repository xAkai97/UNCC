# Lab 1: Onboarding and Python Basics

## Introduction

The purpose of this lab is to ensure you have a working development environment on your device and to introduce you to the Python programming language. This will require you to install Python and a working editor on your device. You will also be asked to write a Canvas discussion post in response to an article about software engineering.

### Preface

If you want to view these instructions in Google Chrome, we recommend installing this [Markdown Viewer Chrome Extension](https://chrome.google.com/webstore/detail/markdown-viewer/ckkdlimhmcjmikdlpkmbgfkaikojcbjk?hl=en).

## Task 1: Setup Your Integrated Development Environment

- Install an IDE on your device. This can be any general IDE, but we recommend [Visual Studio Code](https://code.visualstudio.com/).
  - If you are using Windows, you should also install the [Windows Terminal from the Microsoft Store](<https://www.microsoft.com/en-us/p/windows-terminal/9n0dx20hk701?activetab=pivot:overviewtab>) and [Windows Subsystem for Linux 2](https://docs.microsoft.com/en-us/windows/wsl/install-win10)
  - If you are using Mac, you should also install [Homebrew](https://brew.sh/).
  - If you are using a Mac and do not know how to access your terminal, you can follow [these instructions](https://support.apple.com/guide/terminal/open-or-quit-terminal-apd5265185d-f365-44cb-8b09-71a064a42125/mac#:~:text=Terminal%20for%20me-,Open%20Terminal,%2C%20then%20double%2Dclick%20Terminal./).
- Make sure you know how to create files, access project directories, and run programs from the terminal.

## Task 2: Install and Run Python3.10.8 on Your Device

- For Mac users with Homebrew installed
  - Open a terminal and run the following command:
    - `brew install python3@3.10`
- For Mac users without Homebrew installed
  - Go to the [Python3.10 download page](https://www.python.org/downloads/release/python-3108/) and download the appropriate installer for your device (Mac).
  - Complete the installation of Python3.10.8 on your device, as prompted by the installer.
- For Linux (including Windows users with WSL installed) users
  - ensure that your system is up to date by running the following commands in your linux terminal:
    - `sudo apt update`
    - `sudo apt upgrade`
  - install Python3.10.8 by running the following command in a linux terminal:
    - `sudo apt install python3.10`
  - Complete the installation of Python3.10 on your device, as prompted by the installer.
- Verify that Python3.10.8 is installed on your device by running the following command in a terminal:
  - `python3.10 --version`
  - If you see a version number that is not `3.10.8`, you may need to uninstall whatever version of Python you have installed and try again. Here's a walkthrough for [uninstalling Python](https://www.educative.io/answers/how-to-uninstall-python)
  - **TIP:** If you are using Windows, you may need to run `py -3.10 --version` instead.
  - **TIP:** If you are using Mac, you may need to run `python3 --version` instead.
- VS Code users are recommended to install the [VS Code Python Extensions](https://marketplace.visualstudio.com/items?itemName=ms-python.python).
- Open your course folder in your IDE.
- Open the `helloWorld.py` file.
- Complete `TODO 1` by finishing the `greet` function so that it correctly prints `Hello, World!`.
  - **TIP:** Make sure it prints `Hello, World!` and not `Hello, World`, `Hello World!`, `Hello World`, or any other variation. An error here will cause your submission to fail the autograder, and you will lose points.

## Task 3: The Curran Article Discussion Post

- This article can be found in module 1 of the course Canvas page or [at this link](https://ubiquity.acm.org/article.cfm?id=763745).
- Finish the discussion post assignment on Canvas for this week and paste your original response into the file `response.txt` located in the `lab1` directory.

### Canvas Discussion

- Minimum of 125 words; maximum of 500 words.
- Choose a field of study that is related to Software Engineering, and write a response (between 125 and 500 words) that answers the following questions:
  - What is the field of study? (e.g., Marketing, Management, IT, Psychology, etc.)
  - What is the relationship between the field of study and Software Engineering?
  - How does this field of study rank in terms of scientific rigor?
- Respond to at least two of your classmates' discussion posts by Sunday, 01/15/2023 at 11:59 PM.

## Task 4: IO in Python

- Open the `responseReader.py` file.
- Complete `TODO 2` by finishing `read_file` function so that it returns a string containing the contents a given file name (e.g., `response.txt`).
  - **TIP:** Section 7.2 of the [Python input/output documentation](https://docs.python.org/3.10/tutorial/inputoutput.html) may be helpful.
- Run the `responseReader.py` file to see if your response meets the length requirements.

## Task 5: Converting Types and Using Built-in Functions

- Open the `hashStudentID.py` file.
- Complete `TODO 3` in the `key_from_student_ids` function by converting the student ID variables to integers.
- Complete `TODO 4` in the `key_from_student_ids` function by putting both student ID variables into a tuple named `hashed_tuple`. The function returns this tuple, so the variable name must be the same.
  - **TIP:** Official documentation for the built-in `hash()` function can be found [here](https://docs.python.org/3/library/functions.html#hash).
- Run the `hashStudentID.py` file and test that both main menu options work as expected. Tests are already written for you, just read the output and look for errors. If you see errors, fix them.

## Task 6: Mixed Types

- Open the `keyCollection.py` file and read through the code.
- Complete `TODO 5` inside the `add_student_id_record` method by properly adding the key/value pair to the `student_ids` attribute of the `StudentIDManager` class.
- Complete `TODO 6` inside the `calculate_all_keys` method by grabbing the first and last names for each student ID and concateninating them together with a single space in between.
- Complete `TODO 7` inside the `calculate_all_keys` method by calling the `key_from_student_ids` function from the `hashStudentID.py` file and storing it into the variable called `key`.
- Complete `TODO 8` inside the `calculate_all_keys` method by creating a list of `key`, `full_name_A`, and `full_name_B` in that order. Name the list `key_info`.
- Complete `TODO 9` inside the `calculate_all_keys` method by appending the `key_info` list to the `keys` list.

## Task 7: Using our Methods and Writing to a File

- Stay in the `keyCollection.py` file.
- Complete `TODO 10` inside the `main` function by calling the `add_student_id_record` method twice and passing in the information from `student_one` and `student_two` respectively.
- Complete `TODO 11` inside the `main` function by calling the `write_all_ids_to_file` method and passing in the `keys.txt` file name.

## Submission Details

- On Canvas, submit the following:
  - A zip file of the entire `lab1` directory, renamed as your NinerNetID.zip (e.g., dgary9.zip)
    - **TIP:** For Mac or Linux users,here's an example of how to do it from the terminal on Mac or Linux machines: `zip -r dgary9.zip .`
    - **TIP:** For Windows users who want to use their terminal to zip their submission, you can use the `7za` command. Here's an example of how to do it: `7za dgary9.zip .`
    - **NOTE:** In the above examples, `dgary9` is the NinerNetID of the student submitting the assignment and `.` is the directory that contains the files to be zipped, which is the current directory (`lab1`) in this case, meaning you must have navigated to the `lab1` directory before running the command.
