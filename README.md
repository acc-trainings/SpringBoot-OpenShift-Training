# Spring boot Cloud Native using OpenShift Service Mesh

## Objective
This is a quick reference guide with step by step instructions on how you can setup service mesh on openshift platform and enable service communication between Policy and Customer service. 

## Prerequisties

### **`Knowledge`**
* Basic understanding Openshift.
* Basic understanding of YMAL.
* Basic understanding of quay registry.

### **`installed Softwares`**
* OpenShift CLI
* Any text editor

### **`Application Deployment`**
* Namespace for istio system is already create  with name - acctrainings-istio-system-<your first name>
* Namespace for applications is already create  with name - acctrainings-<your first name>
* Customer service is deployed using Deployments configuration in application namespace
* Version 1 of Policy Service is deployed using Deployments configuration in application namespace

## Steps for installation of Service Mesh
To install service mesh, we will be using OpenShift CLI. Follow steps to login to OpenShift cluster using OpenShift CLI.

### **`Login to cluster using OpenShift CLI`**
* open command prompt and change directory to location where OpenShift CLI is downloaded.
* Login to OpenShift cluster by [clicking here](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812) 
* Select oktaidp to login and provide User Name and Password used to setup Okta account.
* Click top right corner on arrow next to your name and click "Copy Login Command".
        ![Copy Login Command](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/img/CopyLoginCommand.JPG?raw=true)
* Click on Oktaidp again, this will take you to the page with "Display Token" link on the screen.
        ![Display Token](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/img/DisplayToken.JPG?raw=true)
* Click display token and then copy whole command under "Log in with this token"
        ![LogInToken](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/img/LogInToken.JPG?raw=true)
* Paste it on OC CLI and hit enter








