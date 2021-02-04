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

### **`Install Operators`**
The Service Mesh installation process uses the OperatorHub to install the ServiceMeshControlPlane custom resource definition within the openshift-operators project. The Red Hat OpenShift Service Mesh defines and monitors the ServiceMeshControlPlane related to the deployment, update, and deletion of the control plane.

Starting with Red Hat OpenShift Service Mesh 1.1.11, you must install the Elasticsearch Operator, the Jaeger Operator, and the Kiali Operator before the Red Hat OpenShift Service Mesh Operator can install the control plane.

All the Operators will be installed as part of project creation. Please confim that istio system project:  acctrainings-istio-system-<your first name> has all the operators in ready state.

You should see following screen in OpenShift console where all operators are installed state.        
      ![LogInToken](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/img/installedOperators.JPG)

### **`Deploying the Red Hat OpenShift Service Mesh control plane`**  

To install servicemesh control plane, follow below procedures:

* If project is not created, you can create by running following command
   ```javascript
       oc new-project acctrainings-istio-system-<your first name>
   ```
* Create a ServiceMeshControlPlane file named istio-servicemeshmemberroll-default.yaml. [Click here](https://github.com/acc-trainings/customer-api/tree/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh) for location. You can customize the values as needed to match your use case.
* Run the following command to deploy the control plane:
   ```javascript
       oc create -n acctrainings-istio-system-<your first name> -f https://raw.githubusercontent.com/acc-trainings/customer-api/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ServiceMeshControlPlane-installation.yaml
   ```
* Execute the following command to see the status of the control plane installation.
   ```javascript
       oc get smcp -n acctrainings-istio-system-<your first name>
   ```
  The installation has finished successfully when the READY column is true.
   ```javascript
       NAME           READY
       basic-install   True
   ```
* Run the following command to watch the progress of the Pods during the installation process:
   ```javascript
       oc get pods -n acctrainings-istio-system-<your first name> -w
    ```
  Examlpe output
    ```javascript
        NAME                                     READY   STATUS             RESTARTS   AGE
        grafana-7bf5764d9d-2b2f6                 2/2     Running            0          28h
        istio-citadel-576b9c5bbd-z84z4           1/1     Running            0          28h
        istio-egressgateway-5476bc4656-r4zdv     1/1     Running            0          28h
        istio-galley-7d57b47bb7-lqdxv            1/1     Running            0          28h
        istio-ingressgateway-dbb8f7f46-ct6n5     1/1     Running            0          28h
        istio-pilot-546bf69578-ccg5x             2/2     Running            0          28h
        istio-policy-77fd498655-7pvjw            2/2     Running            0          28h
        istio-sidecar-injector-df45bd899-ctxdt   1/1     Running            0          28h
        istio-telemetry-66f697d6d5-cj28l         2/2     Running            0          28h
        jaeger-896945cbc-7lqrr                   2/2     Running            0          11h
        kiali-78d9c5b87c-snjzh                   1/1     Running            0          22h
        prometheus-6dff867c97-gr2n5              2/2     Running            0          28h
      ```

### **`Creating the Red Hat OpenShift Service Mesh member roll`**  
Follow this procedure to add a project to the ServiceMeshMemberRoll from the command line.

* Create a ServiceMeshMemberRoll resource in the same project as the ServiceMeshControlPlane resource, in our example that is acctrainings-istio-system-<your first name>. [Click here](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-servicemeshmemberroll-default.yaml) for location. You have to customize the value of members by replacing existing value with you application namespace i.e. acctrainings-<your first name>. The resource must be named default.

* Run the following command to apply member roll:
   ```javascript
        oc create -n acctrainings-istio-system-<your first name> -f <Path of your yaml file>
   ```

### **`Creating Istio Ingress Gateway for Istio System Namespace`** 

* Look at the config [here] (https://github.com/acc-trainings/customer-api/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ingress-gateway.yaml), it has settings to allowing traffic to the gateway, to keep it simple for excercise, we will allow all http traffic

* Run the following command to apply gateway:
  ```javascript
        oc apply -n acctrainings-istio-system-<your first name> -f https://raw.githubusercontent.com/acc-trainings/customer-api/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ingress-gateway.yaml
  ```
### **`Creating Istio Ingress Gateway for Application Namespace`** 
* Look at the config [here] (https://github.com/acc-trainings/customer-api/blob/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/acctrainings-gateway.yaml), to keep it simple for demo, we will allow all http traffic

* Run the following command to apply gateway:
   ```javascript
       oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/customer-api/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/acctrainings-gateway.yaml
   ```
### **`Creating Virtual Service`** 

* Look at the config [here](https://github.com/acc-trainings/customer-api/blob/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/Policy-service-virtual-service.yaml), it has settings routing traffic to application
*  Run the following command to apply Virtual Service:
    ```javascript
       oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/customer-api/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/Policy-service-virtual-service.yaml
    ```
### **`Inject Side Car`** 

* Open the application’s configuration YAML file in an editor.
* Add sidecar.istio.io/inject to the deployment configuration YAML with a value of "true"
* Check POD of the service - it will have 2 container in same pod
* Test with istio gateway path
