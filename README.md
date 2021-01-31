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


![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic1.png)


5.	The repo will be downloaded in the “downloaded” folder or any designated folder that your system is set for.
6.	Go to “Download” folder and navigate the repo which you have just downloaded. Unzip the folder.
7.	 Go to https://github.com/acc-trainings.
8.	Click on “New” Button to create a new repo.

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic2.png)

9.	Name your repo name as “customer-service-githubusername”

**NOTE** This naming convention has kept as standard as there would be multiple users are going to create repo. This is to avoid conflicts in the repo name. 

10.	Select “Public” , Check “ Add a README file”
11.	Click on “Create repository”

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic3.png)

12.	An empty repo will be created. Go to your repo URL .
13.	Click on the “Add file” option.
14.	Click on “Upload Files”

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic4.png)


15.	Open the “download” folder where you have unzip the repo folder. Drag and drop all the files and folders from that location to here in this github repo.


![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic5.png)



16.	Click on commit the changes. It should look something like below 


![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic6.png)


At this point of time, your source code repo is ready.


## b.	GitHub Setups for ArgoCD config repo

1.	Go to https://github.com/acc-trainings repo and search for “GoldCopyDevOps-ConfigRepo” repo.


![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/2.Github_ConfigRepo_Setup/pic1.png)

2.	This repo will be act as “Gold Copy” for the ArgoCD Config repo for DevOps demo.
3.	Click on the “Code” section highlighted in Green and choose “Download ZIP’
4.	The repo will be downloaded in the “downloaded” folder or any designated folder that your system is set for.
5.	Go to “Download” folder and navigate the repo which you have just downloaded. Unzip the folder.
6.	Go to https://github.com/acc-trainings
7.	Click on “New” Button to create a new repo.
8.	Name your repo name as “githubusername-ConfigRepo”

**Note** This naming convention has kept as standard as there would be multiple users are going to create repo. This is to avoid conflicts in the repo name. 

9.	Select “Public” , Check “ Add a README file”
10.	Click on “Create repository”
11.	An empty repo will be created. Go to your repo URL .
12.	Click on the “Add file” option.
13.	Click on “Upload Files”
14.	Open the “download” folder where you have unzip the repo folder. Drag and drop all the files and folders from that location to here in this github repo.
15.	Click on commit the changes. It should look something like below 

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/2.Github_ConfigRepo_Setup/pic2.png)

16.	 At this point of time, your source code repo is ready.


## c.	Quay.io repo setup

1.	Go to https://quay.io/organization/necloudnativetraining
2.	Click on the “Create New Repository”  

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/3.quay_setup/Pic1.png)

3.	Give a standard repo name as “customer-servcie-yourgithubusername”
4.	Select “Public”
5.	Select “Empty repository”
6.	Click on “Create Public Repository” to create a repo in quay.

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/3.quay_setup/pic2.png)

7.	Select newly created repository and go to “settings” tab on left hand side bar.

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/3.quay_setup/pic3.png)

8.	In “User and Robot Permission” Section, select “necloudnativetrainingteam” and provide “write” permission and click on “Add Permission”
9.	In “User and Robot Permission” Section, select “necloudnativetraining+openshift_robo_user” and provide “write” permission and click on “Add Permission”

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/3.quay_setup/pic4.png)

10.	Your repo in quay is all set.

## d.	Jenkins console setup
## e.	Beforehand Changes in Jenkinsfile
## f.	Beforehand Changes in appdeploy.yaml file
## g.	ArgoCD Setup

# 2.	Running CI/CD Pipeline job
# 3.	Verify the deployments
