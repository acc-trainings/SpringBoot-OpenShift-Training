# Introduction to DevOps CICD Demo

In this README.md file, Step by Step instructions are mentioned to do hand-on the DevOps Session. Resources can refer this file to follow step by step instruction to setup the OpenShift Project, ArgoCD Project, GitHub Repos as well as Jenkins console.

The follow document will be divided into 3 main categories.

* Pre-requisite setup
* Jenkins console Build and Deploy
* Verification of deployment

Let’s start our Journey:

# Pre-requisite setup

## OpenShift Project Setup

### If Project is not setup in OpenShift already, follow the below steps to create a project.

* Go to https://console-openshift-console.apps.awsopenshift.ne-innovation.com
* Click on the “Project” tab from left hand side under Home.
* Click on the “Create Project “on upper right-hand side on screen

[pic1](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/5.DevOps-CICD/Images/1.OpenShift/pic1.png)

* Provide the standard naming convention for the project name which is pre-requisite for demo session.  In this case, it would be “acctrainings-initialname”.  For this demo purpose, it would be “acctrainings-ketan”

**Note** : Please use only lowercase.

pic2

* Once provided the name, click on “create”. A project will be created.
* Verify that the project is created by going into “Project” Tab.

Pic 3


### Setup Quay credentials 

Since we already know that Image are getting created and pushed into Quay.io, OpenShift also require to connect with Quay to pull the image for the deployment purpose. For this, we are going to setup the credentials in OpenShift. 

* Go to the project that just got created.
* Go to the “Inventory” section and click on “secrets”
Pic 4
* Click on “Create” and choose option as “Image Pull Secret”
Pic 5
* Provide “quay-cred” in “Secret Name” field
* Provide “https://quay.io/acctrainings” in “Registry Server Address” field
* Provide user and password. This will be shared with you in ongoing session
* Once done, it should look like this.
Pic 6
* Click on “Create”
Pic 7
* Go to “WorkloadsSecrets” to verify that the secret is created successfully.
Pic 8
* The credentials setup is completed successfully.


## Branch creation in GitHub Repo
## ArgoCD Project Setup
## Jenkinsfile changes in your branch
## Appdeploy.yaml file changes in your branch

# Jenkins console Build and Deploy

## Jenkins Console Pipeline run

# Verification of deployment

## Image Creation in Quay
## ConfigRepo file changes
## ArgoCD Sync
## OpenShift Deployment 
