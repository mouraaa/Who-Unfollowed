## Prerequisites
Uses a third party extension that downloads a list of instagram followers. Checks if the file is present and compares the original file with the downloaded file. Outputs any changes within that list, deletes both the old and new files and creates a new file with the updated list of users.

You can download the thid party extension here: https://chrome.google.com/webstore/detail/export-list-of-followers/hcdbfckhdcpepllecbkaaojfgipnpbpb?hl=en-US

Be advised of their policies as they may or may not store your account information. Just in case, you can create a secondary email for google chrome and a secondary instagram account so they do not have access to any personal or sensitive information. If you create a secondary instagram account, make sure that account follows the account you actually want to export followers from. (That is how the extension works. If you want to export a list of followers, it must be the account you are logged on to or an account you follow)


## Errors
* `"Exception in thread "main" java.io.FileNotFoundException: afterwards.csv (Is a directory)"` :

1: Make sure you downloaded the "only followers" list and not the "following + followers" list. 

You can check by going to your downloads folder and reading the name of the file you downloaded. If you downloaded the correct file name, it should begin with "followed_by_user". If you downloaded the latter, it will begin with "All_users"

2: If you did so by accident, a file named 'afterwards' will be created in the directory you downloaded the code in and you will have to delete it to continue.
