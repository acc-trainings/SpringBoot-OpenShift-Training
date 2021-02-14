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

* Namespace for istio system is already create  with name - ```acctrainings-istio-system-<your first name>```
* Namespace for applications is already create  with name - ```acctrainings-<your first name>```
* Customer service is deployed using Deployments configuration in application namespace
* Version 1 of Policy Service is deployed using Deployments configuration in application namespace

## Installing Service Mesh

To install service mesh, we will be using OpenShift CLI. Follow steps to login to OpenShift cluster using OpenShift CLI.

### **`Login to cluster using OpenShift CLI`**

* open command prompt and change directory to location where OpenShift CLI is downloaded.
* Login to OpenShift cluster by [clicking here](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812) 
* Select oktaidp to login and provide User Name and Password used to setup Okta account.
* Click top right corner on arrow next to your name and click "Copy Login Command".
        ![Copy Login Command](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/CopyLoginCommand.JPG?raw=true)
* Click on Oktaidp again, this will take you to the page with "Display Token" link on the screen.
        ![Display Token](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/DisplayToken.JPG?raw=true)
* Click display token and then copy whole command under "Log in with this token"
        ![LogInToken](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/LogInToken.JPG?raw=true)
* Paste it on OC CLI and hit enter

### **`Install Operators`**

The Service Mesh installation process uses the OperatorHub to install the ServiceMeshControlPlane custom resource definition within the openshift-operators project. The Red Hat OpenShift Service Mesh defines and monitors the ServiceMeshControlPlane related to the deployment, update, and deletion of the control plane.

Starting with Red Hat OpenShift Service Mesh 1.1.11, you must install the Elasticsearch Operator, the Jaeger Operator, and the Kiali Operator before the Red Hat OpenShift Service Mesh Operator can install the control plane.

All the Operators will be installed as part of project creation. Please confim that istio system project:  ```acctrainings-istio-system-<your first name>``` has all the operators in ready state.

You should see following screen in OpenShift console where all operators are installed state.
      ![InstalledOperators](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/OperatorsInstalled.JPG)

### **`Deploying the Red Hat OpenShift Service Mesh control plane`**  

To install servicemesh control plane, follow below procedures:

* If project is not created, you can create by running following command which will install all required operators as well.

   ```javascript
       oc new-project acctrainings-istio-system-<your first name>
   ```

* Create a ServiceMeshControlPlane file named istio-servicemeshmemberroll-default.yaml. [Click here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ServiceMeshControlPlane-installation.yaml) for location. You can customize the values as needed to match your use case.
* Run the following command to deploy the control plane:

   ```javascript
       oc create -n acctrainings-istio-system-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ServiceMeshControlPlane-installation.yaml
   ```

* Execute the following command to see the status of the control plane installation.

   ```javascript
       oc get smcp -n acctrainings-istio-system-<your first name>
   ```

  The installation has finished successfully when the READY column is true.

   ```javascript
       NAME           READY
       basic          True
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

* Create a ServiceMeshMemberRoll resource in the same project as the ServiceMeshControlPlane resource, in our example that is ```acctrainings-istio-system-<your first name> ```.

 [Click here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-servicemeshmemberroll-default.yaml) for location. You have to customize the value of members by replacing existing value with you application namespace i.e. ```acctrainings-<your first name>```. The resource must be named default.

* Create Service memberRoll by adding from web Console
* Click on Installed Operators for your Project and then click Service Mesh Operator
        ![Copy Login Command](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/MemberRoll.JPG?raw=true)
  
* Click "Istio Service Mesh Member Roll"
        ![Copy Login Command](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/SelectMR.JPG?raw=true)

* Click button "Create ServiceMeshMemberRoll" to add configuration
        ![Copy Login Command](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/ButtonMR.JPG?raw=true)

* Select "YAML View" and add name of your project under member section
        ![Copy Login Command](https://github.com/acc-trainings/SpringBoot-OpenShift-Training/blob/6.service-mesh/img/MemberName.JPG?raw=true)

* Alternatively, copy YAML file form [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-servicemeshmemberroll-default.yaml), add member name and run the following command to apply member roll:

   ```javascript
        oc create -n acctrainings-istio-system-<your first name> -f <Path of your yaml file>
   ```

### **`Creating Istio Ingress Gateway for Istio System Namespace`** 

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ingress-gateway.yaml), it has settings to allowing traffic to the gateway, to keep it simple for excercise, we will allow all http traffic

* Run the following command to apply gateway:

  ```javascript
        oc apply -n acctrainings-istio-system-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/istio-ingress-gateway.yaml
  ```

### **`Creating Istio Ingress Gateway for Application Namespace`** 

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/acctrainings-gateway.yaml), to keep it simple for demo, we will allow all http traffic

* Run the following command to apply gateway:

   ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/acctrainings-gateway.yaml
   ```

* Note: if ```acctrainings-<your first name>``` is not yet available, use following command to create it.

   ```javascript
        oc new-project acctrainings-<your first name>
   ```

### **`Deploy Applications`**

In order to move forward with service mesh, we will need Customer-api and policy-api to be deployed on your project. If these are not yet deployed, follow steps to deploy -

#### **`Customer API Deployment`**

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/API%20Deployments%20Configs/customer-api.yaml), it has configurations for -
  * ConfigMap - The ConfigMap object provides mechanisms to inject containers with configuration data while keeping containers agnostic of OpenShift Container   Platform. A ConfigMap can be used to store fine-grained information like individual properties or coarse-grained information like entire configuration files or JSON blobs.
  * Service - An abstract way to expose an application running on a set of Pods as a network service.
  * Deployment -  Deployments describe the desired state of a particular component of an application as a Pod template.
  * Route - Configuration to create route to be exposed for your service deployed on POD.

* Run the following command to deploy customer api:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/API%20Deployments%20Configs/customer-api.yaml
    ```

#### **`Policy API Deployment`**

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/API%20Deployments%20Configs/policy-api-v1.yaml)

* Run the following command to deploy customer api:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/API%20Deployments%20Configs/policy-api-v1.yaml
    ```

### **`Inject Side Car`**

* Open the application’s configuration YAML file in an editor.
* Add sidecar to the deployments configuration YAML with a value of "true" under metadata.annotations

    ```javascript
        metadata:
          annotations:
            sidecar.istio.io/inject: 'true'
    ```

* Check POD of the service - it will have 2 container in same pod
* Test with istio gateway path

### **`Create Virtual Service`**

#### **`Virtual Service for Customer API`**

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/customer-api-virtual-service.yaml), it has settings routing traffic to application

* Run the following command to apply Virtual Service:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/customer-api-virtual-service.yaml
    ```

#### **`Virtual Service for Policy API`**

* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/policy-api-virtual-service.yaml), it has settings routing traffic to application

* Run the following command to apply Virtual Service:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%201%20-%20Installing%20Service%20Mesh/policy-api-virtual-service.yaml
    ```

## Traffic management

Istio’s traffic routing rules let you easily control the flow of traffic and API calls between services. Istio simplifies configuration of service-level properties like circuit breakers, timeouts, and retries, and makes it easy to set up important tasks like A/B testing, canary rollouts, and staged rollouts with percentage-based traffic splits. It also provides out-of-box failure recovery features that help make your application more robust against failures of dependent services or the network.

For this session, we will focus on Load balancing, Network resilience and testing.

### Load Balancing

### **`Deploy version 2 of Policy-api`**

* To observe load balancing, we will deploy policy-api-v2.
* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%202%20-%20Load%20Balancing/policy-api-v2.yaml)

* Run the following command to deploy policy-api-v2:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%202%20-%20Load%20Balancing/policy-api-v2.yaml
    ```

* Start refresing browser to see V1 and V2 of the policy service bringing data alternativly, this is default Round Robin behaviour for load balancing.

### **`Apply Destination Rule`**

* Enable Destination Rule to Observe Random and Least Requests load balancing behaviour.
* Look at the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%202%20-%20Load%20Balancing/policy-service-destination-rule.yaml)

* Run the following command to deploy policy-api-v2:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%202%20-%20Load%20Balancing/policy-service-destination-rule.yaml
    ```

* Start refresing browser to see V1 and V2 of the policy service bringing data randomly.

### Network resilience and testing

### **`Setting Timeouts and retries`**

* Set timeout and retries setting in Policy-api-virtual-service.
* Add following lines at the end in Virtual service

    ```javascript
        timeout: 5s
        retries:
          attempts: 3
          perTryTimeout: 2s
    ```

* Alternativey delete ```policy-api-virtual-service``` and run following command to add new virtual service with timeout and retry configuration

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%203%20-%20Network%20resilience%20and%20Fault%20Injection/Policy-service-virtual-service-timeout.yaml
    ```

### **`Fault Injection and testing`**

* Inject delays using Virtual service configuration
* Delete ```policy-api-virtual-service```
* Look at fault section in the config [here](https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%203%20-%20Network%20resilience%20and%20Fault%20Injection/Policy-service-virtual-service-fault-injection.yaml).
* Run the following command to apply fault injection configuration:

    ```javascript
        oc apply -n acctrainings-<your first name> -f https://raw.githubusercontent.com/acc-trainings/SpringBoot-OpenShift-Training/6.service-mesh/Excercise%20-%203%20-%20Network%20resilience%20and%20Fault%20Injection/Policy-service-virtual-service-fault-injection.yaml
    ```

* Start refresing browser to see 7s delay in response.
