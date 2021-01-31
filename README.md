# Introduction to DevOps CICD Demo
This readme file is having step by steps instruction to configure the setup for demo . The setup is divided into 3 parts 
* Pre-Requisite setup
* Running CI/CD Pipeline job
* Verify the deployments

Any user should go through these steps while planning to setup for the configuration.

Lets start with step by step instructions for setup.

# 1.	Pre-requisite setups 

## a. GitHub Setups for source code repo
1.	Go to https://github.com/acc-trainings repo 
2.	Search for “customer-service-GoldCopyDevOps" repo.
3.	This repo will be act as “Gold Copy” for the source code for DevOps demo.
4.	Click on the “Code” section highlighted in Green and choose “Download ZIP”


![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic1.png)


5.	The repo will be downloaded in the “Download” folder or any designated folder that your system is set for.
6.	Go to “Download” folder and navigate the repo name zip folder which you have just downloaded. Unzip the folder.
7.	Go to https://github.com/acc-trainings
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


15.	Open the “Download” folder where you had unzipped the repo folder. Drag and drop all the files and folders from unzip folder location to here in this github repo.


![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic5.png)



16.	Click on commit the changes. It should look something like below 


![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/1.Github_SourceCode_Setup/pic6.png)


At this point of time, your source code repo is ready.


## b.	GitHub Setups for ArgoCD config repo

1.	Go to https://github.com/acc-trainings repo and search for “GoldCopyDevOps-ConfigRepo” repo.


![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/2.Github_ConfigRepo_Setup/pic1.png)

2.	This repo will be act as “Gold Copy” for the ArgoCD Config repo for DevOps demo.
3.	Click on the “Code” section highlighted in Green and choose “Download ZIP"
4.	The repo will be downloaded in the “Download” folder or any designated folder that your system is set for.
5.	Go to “Download” folder and navigate the repo which you have just downloaded. Unzip the folder.
6.	Go to https://github.com/acc-trainings
7.	Click on “New” Button to create a new repo
8.	Name your repo name as “githubusername-ConfigRepo”

**Note** This naming convention has kept as standard as there would be multiple users are going to create repo. This is to avoid conflicts in the repo name. 

9.	Select “Public” , Check “ Add a README file”
10.	Click on “Create repository”
11.	An empty repo will be created. Go to your repo URL
12.	Click on the “Add file” option.
13.	Click on “Upload Files”
14.	Open the “Download” folder where you have unzipped the repo folder. Drag and drop all the files and folders from unzip folder location to here in this github repo.
15.	Click on commit the changes. It should look something like below 

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/2.Github_ConfigRepo_Setup/pic2.png)

16.	 At this point of time, your Config repo is ready.


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

10.	Your repo in quay.io is all set.

## d.	Jenkins console setup

1. Go to https://jenkins-jenkins-ne-demo.apps.awsopenshift.ne-innovation.com/
2.  click on “Login with OpenShift”
3.  click on “oktaidp” 
4.  click on the username section on top right corner 

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic1.png)

5.  click on the “credentials” menu on lift hand side pane.

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic2.png)

6.	Click on Jenkins from “Stores from Parent” Section 

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic3.png)

7.	Click on “Global Credentials (unrestricted) “ option

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic4.png)

8.	Click on “Add Credentails” from left hand side menu.
9.	Provide User name and password for your “GitHub” account. 
10.	Provide the “ID” as unique name which can be identified for GitHub credentials
11.	Provide “Description” as you want.

![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic5.png)


6.	Follow the same steps from step 9 
7.	Provide user name and password for “quay” account. Here the user name and password will come from:
a.	Go to https://quay.io/organization/necloudnativetraining?tab=robots
b.	Click on the “Account name” 

![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic6.png)

c.	Copy the username and Robot token

![pic7](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic7.png)

14.	Paste the username in “username” section of credentials
15.	Paste the Robot token in “password” section of the credentials 

![pic8](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic8.png)

When both are done, your credential list should look like this :

![pic9](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/4.Jenkins_console_setup/pic9.png)


## e.	Jenkinsfile changes

1.	Go to your Source code repo. In my case, it would be https://github.com/acc-trainings/customer-service-ketanchhatbar
2.	Click on the Jenkinsfile and click on “Edit” icon to edit the file.

![pic9](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic9.png)

3.	Go to line No. 24 and update the repository name in which your Jenkinsfile is residing.

![pic8](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic8.png)

4.	Go to Line no  45 , 58 & 70 and replace the “credentialsID “ with the quayID that you have created in Jenkins console. 

![pic7](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic7.png)

5.	Go to Line No. 60 & 73 and replace the repo name with the one that you have created in quay.io repo.

![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic6.png)

![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic5.png)


6.	Go to Line no. 84 and replace the credential ID with the GithubID that you have setup in Jenkins console. 

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic4.png)

7.	Go to Line No. 88, 89, 100 & 101  and update your github username and email id 

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic3.png)

8.	Go to Line 91 and 108 and update the ArgoCD config Repo URL 

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/pic2.png)

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/5.Jenkinsfile_changes/Pic1.png)

9.	Click on “ Commit Changes” . The Jenkinsfile setup is completed.

## f.	Appdeploy.yaml file changes

1. Go to https://github.com/acc-trainings/customer-service-ketanchhatbar
2. Navigate to “Deployment” folder. 
3. Click on edit for “appdeploy.yaml” file
4. Update Line No. 4,17,44  & 49 and update the name as “customer-service-yourgithubusername” . This name will be used in ArgoCD Application setup which has to be unique.

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/6.appdeployfile_changes/pic2.png)

5. Update Line No. 31 with the quay repo name that you have created in quay.io.

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/6.appdeployfile_changes/pic1.png)


6. Commit the changes and the appdeploy.yaml file setup is completed.

## g.	ArgoCD Setup

1. Go to https://argocd-server-argocd.apps.awsopenshift.ne-innovation.com
2. Provide username and password to sign in.

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic1.png)

3. Go to “Manage your Repo” icon on left hand side panel 

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic2.png)

4. Click on “Repository” option.

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic3.png)

5. click on “Connect Repo using HTTPS” option.

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic4.png)

6. Provide the Config Repo URL which you have created in Github and provide github user name and password to connect to the repo.

![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic5.png)

7. Click on connect. The connection should need to be successful. It should look like as below :

![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic6.png)

8. Go to “Manage your Application” tab from Left hand side panel

![pic7](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic7.png)

9. Click on “New App”

![pic8](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic8.png)

10.	Provide application name as what you have given in your appdeploy.yaml file, which would be “customer-service-yourgithubusername”
11.	Provide Project as”default”
12.	Set “Sync Policy” to “Autometic”
13.	Select the config repo from drop down of “Repository URL” option
14.	Revision should be “HEAD”
15.	Path needs to be set as “.” (dot)
16.	Select default cluster URL 
17.	Provide the namespace to “springboot-workshop-feb-2021”

![pic9](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic9.png)
![pic10](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic10.png)
![pic11](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic11.png)


18.	Click on “Create”. This will create an application in ArgoCD.

![pic12](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/7.Argocd_setup/pic12.png)



# 2.	Running CI/CD Pipeline job

1. Go to https://jenkins-jenkins-ne-demo.apps.awsopenshift.ne-innovation.com/
2. Click on “New Item” from left hand side menu

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic1.png)

3. 	Provide the name of the pipeline job and select the “Pipeline” Option and click OK.

![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic2.png)

4.  The Pipeline job will be opened in Edit mode. Got o “Advanced Project Option” 
5. select the definition as “Pipeline script from SCM”
6. Select “SCM” as “Git”
7. Provide repo URL as the Source Code git repo where you have saved your Jenkinsfile
8. Select the Github Credential from drop down . This is the one which you have created beforehand in credentials section.
9. set “Branch to build” as “*/main”
10. Provide the Jenkinsfile name in “Script Path” option.


![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic3.png)

11.	Click on Save.
12.	Go to Pipeline job and click on “Build Now”

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic4.png)

13.	The pipeline job will start running

![pic5](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic5.png)

14.	Go to console output section to check the progress of the job

![pic6](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic6.png)

15. The Pipeline job is completed Now. 

![pic7](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/8.Running_pipeline_setup/pic7.png)


# 3.	Verify the deployments

1. Let’s go to quay.io and see ,if you are able to see the latest image tag
2. Go to https://quay.io/organization/necloudnativetraining
3. Go to the repo that you have created here	 - https://quay.io/repository/necloudnativetraining/customer-service-ketanchhatbar
4. Go to “Tag” Section and validate the tag name.

![pic1](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/9.Verify_deployments/pic1.png)

5. Go to Argocd Tool and select the application that you have created.
https://argocd-server-argocd.apps.awsopenshift.ne-innovation.com/applications
6. The deployment is synced successfully as you can see the Sync OK and Synced status is shown Green.


![pic2](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/9.Verify_deployments/pic2.png)

7. Go to OpenShift: 
https://console-openshift-console.apps.awsopenshift.ne-innovation.com/k8s/cluster/projects
8. Click on “springboot-workshop-feb-2021” project’
https://console-openshift-console.apps.awsopenshift.ne-innovation.com/k8s/cluster/projects/springboot-workshop-feb-2021

![pic3](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/9.Verify_deployments/pic3.png)

9.  Click on Pods
10. You should be able to see 3 Pods with the naming convention that you have given in the appdeploy.yaml file. 

![pic4](https://github.com/acc-trainings/customer-api/blob/5.DevOps-CICD/9.Verify_deployments/pic4.png)

This concludes the deployment to Openshift via ArgoCD with the help of CICD.

