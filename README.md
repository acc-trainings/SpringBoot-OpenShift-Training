# Introduction to DevOps CICD Demo

In this README.md file, Step by Step instructions are mentioned to do hand-on the DevOps Session. Resources can refer this file to follow step by step instruction to setup the OpenShift Project, ArgoCD Project, GitHub Repos as well as Jenkins console.

The follow document will be divided into 3 main categories.

* Pre-requisite setup
* Jenkins console Build and Deploy
* Verification of deployment

Let’s start our Journey:

# A. Pre-requisite setup

## 1. Update from Main 

In order to get the Jenkins pipeline related file into your dedicated branch , please follow the below steps .

* Go to Git Desktop
* Make sure you are in your dedicated branch 

<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Upload_to_main/pic1.png) </kbd>


* From the Menu bar , go to “Branch” and click on “Update from Main”


<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Upload_to_main/pic2.png) </kbd>


* Once done , Click on the “Push Origin”


<kbd>![pic3](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Upload_to_main/pic3.png) </kbd>


* Once done, The files from the Main branch will be available in your dedicated Branch


## 2. OpenShift Project Setup

### 1.1 If Project is not setup in OpenShift already, follow the below steps to create a project.

* Go to https://console-openshift-console.apps.awsopenshift.ne-innovation.com
* Click on the “Project” tab from left hand side under Home.
* Click on the “Create Project “on upper right-hand side on screen

<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic1.png) </kbd>

* Provide the standard naming convention for the project name which is pre-requisite for demo session.  In this case, it would be “acctrainings-initialname”.  For this demo purpose, it would be “acctrainings-ketan”

**Note** : Please use only lowercase.

<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic2.png)</kbd>

* Once provided the name, click on “create”. A project will be created.
* Verify that the project is created by going into “Project” Tab.

<kbd>![pic3](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic3.png)</kbd>

### 1.2 Setup Quay credentials 

Since we already know that Image are getting created and pushed into Quay.io, OpenShift also require to connect with Quay to pull the image for the deployment purpose. For this, we are going to setup the credentials in OpenShift. 

* Go to the project that just got created.
* Go to the “Inventory” section and click on “secrets”

<kbd>![pic4](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic4.png)</kbd>

* Click on “Create” and choose option as “Image Pull Secret”

<kbd>![pic5](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic5.png)</kbd>

* Provide “quay-cred” in “Secret Name” field
* Provide “https://quay.io/acctrainings” in “Registry Server Address” field
* Provide user and password. This will be shared with you in ongoing session
* Once done, it should look like this.

<kbd>![pic6](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic6.png)</kbd>

* Click on “Create”

<kbd>![pic7](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic7.png)</kbd>

* Go to “WorkloadsSecrets” to verify that the secret is created successfully.

<kbd>![pic8](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic8.png)</kbd>

* The credentials setup is completed successfully.


## 3. Branch creation in GitHub Repo

### 3.1 Create branch from ConfigRepo

ConfigRepo is a GitHub repository name in which the appdeploy.yaml file resides. ArgoCD listen the latest changes in this file and initial the deployment into OpenShift project

* Go to https://github.com/acc-trainings/customer-api-configrepo
* Click on the “main” and Provide the branch name. As per demo naming standards it should be “customer-api-configrepo-initialname”. For this demo purpose, it would be “customer-api-configrepo-ketan”
* Click on “Create branch”


<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Branch_/pic1.png)</kbd>

* It will get clone of all the files that are available in “main” branch.
* Verify that the branch is created successfully.

<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Branch_/pic2.png)</kbd>



## 4. ArgoCD Project Setup

* Go to https://argocd-server-argocd.apps.awsopenshift.ne-innovation.com/applications
* Click on “+ New App”

<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/3.ArgoCD_Setup/pic1.png)</kbd>

* Provide “acctrainings-initialname” in “Application Name” field. For this demo purpose, it would be “acctrainings-ketan”
* Select “default” from drop down in “Project” field
* Select “Automatic” from drop down in “SYNC POLICY” field
* Check “PRUNE RESOUECES”.
* In the “Source” section, select repo URL from drop down in “Repsitory URL” field.
* Provide branch name as “customer-api-configrepo-initialname” in “Revision” field. For this demo purpose, it would be “customer-api-configrepo-ketan”
* Provide “.” (dot) in the “Path” field
* In the “Destination” section, select default URL from drop down in “Cluster URL” field
* Provide name as “acctrainings-initialname” in “namespace” field. For this demo purpose, it would be “acctrainings-ketan”

<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/argo_/pic1.png)</kbd>


<kbd>![pic3](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/argo_/pic2.png)</kbd>

* Click on the create as top.

<kbd>![pic4](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/3.ArgoCD_Setup/pic4.png)</kbd>

* The Project setup in ArgoCD is completed.

## 5. Jenkinsfile changes in your branch

* Go to your source code GitHub Repo branch
* Click on the “Jenkinsfile” and click on “edit”
* Go to Line no. 92. 

<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/4.Jenkinsfile_Changes/pic1.png)</kbd>

* Replace the “main” with the branch name you have created which is “customer-api-initialname”. For this demo purpose, it would be “customer-api-ketan”

<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/Jenkins_/pic1.png)</kbd>

e.	Commit the changes.

## 6. Appdeploy.yaml file changes in your branch

* Go to your source code GitHub Repo branch
* Navigate to the “Deployment Folder”
* Open “appdeploy.yaml” file in edit mode
* Find “initial” and replace it with your initial name for all the entries.

`Before`


<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/5.appdeployfile_changes/pic1.png)</kbd>

`After`


<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/5.appdeployfile_changes/pic2.png)</kbd>


e.	Once changes is applied, commit the changes.


# B. Jenkins console Build and Deploy

* Go to https://jenkins-jenkins-ne-demo.apps.awsopenshift.ne-innovation.com/job/customer-api
* Click “Scan Multibranch Pipeline Now”. This will scan any new branch created in GitHub Source code repo.
* Once the Operation is completed, you will be able to see your pipeline job which would be exactly the name as your branch name in source code repo.


<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/6.JenkinsConsole_Setup/pic1.png)</kbd>

* Click on the pipeline job.
* Click on “Build” option from left hand side menu


<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/6.JenkinsConsole_Setup/pic2.png)</kbd>

* Upon click , the pipeline job will be triggered. 


<kbd>![pic3](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/6.JenkinsConsole_Setup/pic2.png)</kbd>


* Wait until pipeline job run completed
* Pipeline job build and deploy is completed successfully.


<kbd>![pic4](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/6.JenkinsConsole_Setup/pic4.png)</kbd>



# C. Verification of deployment

## 1. Image Creation in Quay

* Go to https://quay.io/repository/acctrainings/customer-api?tab=tags
* Verify that the image is created successfully. Image name should be suffixed with the your name 

<kbd>![pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic1.png)</kbd>


## 2. ConfigRepo file changes

* Go to https://github.com/acc-trainings/customer-api-configrepo
* Go to your Branch name
* Verify that the recent commit timestamp on “appdeploy.yaml” file. It should be recent.

<kbd>![pic6](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic6.png)</kbd>


## 3. ArgoCD Sync

* Go to https://argocd-server-argocd.apps.awsopenshift.ne-innovation.com/applications
* Click on the project with your name.

<kbd>![pic2](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic2.png)</kbd>


* Verify that sync process is successful and showing “Synced” and “Sync OK”


<kbd>![pic3](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic3.png)</kbd>



## 4. OpenShift Deployment 

* Go to https://console-openshift-console.apps.awsopenshift.ne-innovation.com
* Click on the “Project” tab from left hand side under Home.
* Go to the project that you have created. 
* Go to the “Inventory” section and click on “pods”


<kbd>![pic4](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic4.png)</kbd>

* Once in the pods, you should be able to see the pod is in running state. 


<kbd>![pic5](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/7.Verify_Deployment/pic5.png)</kbd>

* Verify the Route

Open browser and hit the URL  -->  routeURL/customer-api/swagger-ui

This concludes the demo session.

