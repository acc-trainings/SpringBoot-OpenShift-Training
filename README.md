# Introduction to DevOps CICD Demo
This readme file is having step by steps instruction to configure the setup for demo . The setup is divided into 3 parts 
* Pre-Requsiste setup
* Running CI/CD Pipeline job
* Verify the deployments

Any user should go through the these steps while planning to setup the configuration.

Lets start with step by step instructions for setup.

# 1.	Pre-requisite setups 

## a. GitHub Setups for source code repo
1.	Go to https://github.com/acc-trainings repo 
2.	Search for “customer-service-GoldCopyDevOps" repo.
3.	This repo will be act as “Gold Copy” for the source code for DevOps demo.
4.	Click on the “Code” section highlighted in Green and choose “Download ZIP”


https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic1.png


5.	The repo will be downloaded in the “downloaded” folder or any designated folder that your system is set for.
6.	Go to “Download” folder and navigate the repo which you have just downloaded. Unzip the folder.
7.	 Go to https://github.com/acc-trainings.
8.	Click on “New” Button to create a new repo.

--- pic 2

9.	Name your repo name as “customer-service-githubusername”

**NOTE** This naming convention has kept as standard as there would be multiple users are going to create repo. This is to avoid conflicts in the repo name. 

10.	Select “Public” , Check “ Add a README file”
11.	Click on “Create repository”

--- Pic 3

12.	An empty repo will be created. Go to your repo URL .
13.	Click on the “Add file” option.
14.	Click on “Upload Files”

-- pic 4


15.	Open the “download” folder where you have unzip the repo folder. Drag and drop all the files and folders from that location to here in this github repo.


---pic 5 


16.	Click on commit the changes. It should look something like below 

----pic 6

At this point of time, your source code repo is ready.



## b.	GitHub Setups for ArgoCD config repo
## c.	Quay.io repo setup
## d.	Jenkins console setup
## e.	Beforehand Changes in Jenkinsfile
## f.	Beforehand Changes in appdeploy.yaml file
## g.	ArgoCD Setup

# 2.	Running CI/CD Pipeline job
# 3.	Verify the deployments
