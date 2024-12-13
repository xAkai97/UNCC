# Git Tips and Tricks

This document will provide some tips and tricks for using git, with complete examples to help you understand the confusing parts. Remember that git is a tool, and you should use it to help you do your work, not to make your life more difficult. If you find yourself doing something that is difficult, there is probably a better way to do it. To avoid those tricky situations, read everything in this document (and in the online resources) very, very carefully.

## Installing Git

Many of you will already have git installed on your machine. If you're not sure whether you do, you can check by running `git --version` in your terminal. If you get a version number, you're good to go. If you get an error, you'll need to install git.

Just to show you what it looks like when someone has git installed, here's what it looks like when I run `git --version`:

```bash
davidgary@Davids-MacBook-Pro itsc-3155 % git --version
git version 2.37.1 (Apple Git-137.1)
```

**NOTE:** The example above shows my username, computer name, and the name of the directory I'm in. Yours will be different, so for the future examples, I'll use the following format:

```bash
git --version
```

This just simply means that I am running a command in my terminal.

Let's see what happens when we try to run `git --version` on a machine that doesn't have git installed:

```bash
git --version
bash: git: command not found
```

We get an error message saying that the `git` command is not found. This means that we need to install git. There are a few ways to do this, depending on your operating system.

### Installing Git for Mac

This will depend on whether you have Homebrew installed. If you do, you can run `brew install git` to install git. If you don't, you can download the Git installer from [here](https://git-scm.com/download/mac).

### Installing Git for Windows

You can download the Git installer from [here](https://git-scm.com/download/win).

### Installing Git for Linux

If you're using Linux, I'm shocked that you're still reading this. You probably already know how to install git. If you don't, you can find instructions [here](https://git-scm.com/download/linux), but also you maybe shouldn't be using Linux just yet.

## Configuring Git

After you've installed git, you'll need to do some basic configuration. Luckily, this is a one-time job. Let's start by configuring our names and email addresses so that git knows who we are. I'll be using my personal information for this setup process. Unless we have the same name and email address, you should be sure to replace these values with your own. We'll do this by running the following commands:

```bash
git config --global user.name "David Gary"
git config --global user.email "aaddgirvy@real-email.mom"
```

The `--global` flag tells git to use these values for all of our repositories. If you don't use the `--global` flag, git will only use these values for the current repository. If you want to use different names and email addresses for different repositories, you can omit the `--global` flag. Generally though, use the `--global` flag.

It's also helpful to set your default branch name to `main`. This is the default branch name for GitHub, and it's a good idea to use the same name for all of your repositories. To do this, run the following command:

```bash
git config --global init.defaultBranch main
```

## Connecting to GitHub

This is where things are going to start getting tricky. Many people use GitHub to host their repositories, and in this class, you will be required to do so. For the sake of this exercise, we will assume you already have a GitHub account set up. If you do not, go do that immediately and **DO NOT USE YOUR STUDENT EMAIL WHEN YOU SIGN UP**. Follow the remaining instructions in order to connect your local git installation to your GitHub account.

### Check to See if You Have SSH Keys

The first thing we need to do is check to see if we already have SSH keys set up. If we do, we can skip the next section. To check, we'll run the following command:

```bash
ls -al ~/.ssh
```

This checks the `.ssh` directory in your home directory. If you don't have an `.ssh` directory, you'll get an error message. If you do, you'll see a list of files. If you see a file called `id_rsa.pub`, you already have SSH keys set up. If you don't, you'll need to generate them. Here's what an example of the error message looks like:

```bash
ls -al ~/.ssh
ls: /Users/davidgary/.ssh: No such file or directory
```

Here's what an example of the output looks like with keys already installed:

```bash
total 56
drwx------   9 davidgary  staff   288 Jan  4 14:32 .
drwxr-x---+ 42 davidgary  staff  1344 Jan 19 17:00 ..
-rw-r--r--   1 davidgary  staff   184 Jan  2 15:02 config
-rw-------   1 davidgary  staff   411 Nov  7 21:23 id_ed25519
-rw-r--r--   1 davidgary  staff   100 Nov  7 21:23 id_ed25519.pub
-rw-------   1 davidgary  staff   411 Jan  2 14:59 id_ed25519_gitlab
-rw-r--r--   1 davidgary  staff    97 Jan  2 14:59 id_ed25519_gitlab.pub
-rw-------   1 davidgary  staff  1316 Nov  9 12:52 known_hosts
-rw-------   1 davidgary  staff   750 Nov  9 12:51 known_hosts.old
```

### Generating SSH Keys

**IF YOU ALREADY HAVE SSH KEYS, SKIP THIS SECTION!**

To generate a new SSH key, we'll run a command like this one (remember to change the email address to your own):

```bash
ssh-keygen -t ed25519 -C "aaddgirvy@real-email.mom"
```

This creates a new ssh key that is labeled with the email you supplied. Once you run this, you'll be promped to enter a file for the key. You can just hit enter to accept the default file name. You'll then be prompted to enter a passphrase. You can enter a passphrase if you want, but it's not required. If you do enter a passphrase, you'll be prompted to enter it again. The entire sequence will look something like this:

```bash

Generating public/private ed25519 key pair.

Enter file in which to save the key (/Users/davidgary/.ssh/id_ed25519):

Enter passphrase (empty for no passphrase):

Enter same passphrase again:

Your identification has been saved in /Users/davidgary/.ssh/id_ed25519.

Your public key has been saved in /Users/davidgary/.ssh/id_ed25519.pub.
```

Followed by some cryptic output that you can ignore.

### Adding Your SSH Key to the SSH Agent

The `ssh-agent` is a program that manages your ssh keys in the background and keeps you from needing to enter your passphrase every time you use your key. To start the `ssh-agent` in the background, we'll run the following command:

```bash
eval "$(ssh-agent -s)"
```

This will output something like this:

```bash
Agent pid 59566
```

Next, we will add our private key to the `ssh-agent`. To do this, we'll run the following command:

```bash
ssh-add ~/.ssh/id_ed25519
```

**NOTE:** if you named your file something different, you'll need to change the file name in the command above. Just make sure to not include the `.pub` extension, as that points to our public key.

### Adding Your SSH Key to GitHub

It is now time to add our keys to GitHub. I'd recommend also looking at this [GitHub article](https://docs.github.com/en/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account) on the subject, but if you feel confident in your ability to follow these (nearly identical) instructions, you can continue to do so.

Let's start by copying our public key to a clipboard. This will differ depending on your operating system. For Linux (including WSL), you can run the following command:

```bash
cat ~/.ssh/id_ed25519.pub
  # Then select and copy the contents of the id_ed25519.pub file
  # displayed in the terminal to your clipboard
```

For Mac, you can run the following command:

```bash
pbcopy < ~/.ssh/id_ed25519.pub
```

Next, go to [GitHub](https://github.com) and log in. Once you're logged in, click on your profile picture in the top right corner and select "Settings" from the dropdown menu.

On the left side of the screen, you should see a menu. Click on "SSH and GPG keys".

On the right side of the screen, you should see a button that says "New SSH key". Click on that button. You'll be prompted to enter a title for your key. I'd recommend using something like "Personal Laptop".

Next, you'll be prompted to paste your key into a text box. Paste your key into the text box and click "Add SSH key". You should now see your key listed on the page.
