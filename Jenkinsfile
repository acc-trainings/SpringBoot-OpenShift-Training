#!groovy
pipeline {

agent 
{
    label 'master'
}

    environment {
            SNP_IMG_TAG = "SNAP_1.0.${BUILD_NUMBER}.${BRANCH_NAME}"
                }
    
stages {

     stage('CleanWorkspace') {
            steps {
                deleteDir()
            }
        }
    
        stage('checkout SCM') {
        steps {
            script {
                //checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: 'origin/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'githubglobal', url: 'https://github.com/acc-trainings/customer-api-at-initial']]]
                checkout scm
                println "Branch Name : "+" ${env.BRANCH_NAME}"    
            }
        }
            
       
    }
    stage ('Build JAR')
        {
            steps {
            echo "Checkout completed. Starting the build"
            withMaven(maven: 'maven-latest') {
                sh 'mvn clean install package'
                //stash name:"jar", includes:"target/customer-service-*.jar"
            }
        }
        }

    stage('Login Into Quay') {
    steps {
        script {
        withCredentials([usernamePassword(credentialsId: 'QuayMonitor1' , passwordVariable:'password', usernameVariable:'username')]) {
            sh '''
            docker --version
            docker login quay.io -u ${username} -p ${password}
            '''
    }
    }
    }   
    }    

    stage('Build Image with Quay') {
    steps {
        script {
        withCredentials([usernamePassword(credentialsId: 'QuayMonitor1' , passwordVariable:'password', usernameVariable:'username')]) {
            sh '''
             docker build . -t quay.io/acctrainings/customer-api:${SNP_IMG_TAG}
            '''
    }
    }
    }   
    }    
    
    stage('Push Image to Quay') {
    steps {
        script {
        withCredentials([usernamePassword(credentialsId: 'QuayMonitor1' , passwordVariable:'password', usernameVariable:'username')]) {
            sh '''
             docker login quay.io -u ${username} -p ${password}
             docker push quay.io/acctrainings/customer-api:${SNP_IMG_TAG}
            '''
    }
    }
    }   
    }    

    
    stage('Deploy to Dev') {
    steps {
        script {
        withCredentials([usernamePassword(credentialsId: 'githubglobal1' , passwordVariable:'password', usernameVariable:'username')]) {
            
            sh '''
            git init
            git config --global user.email "acctrainings3@gmail.com"
            git config --global user.name "acctrainings3"
            '''
            sh 'git clone --branch main https://${username}:${password}@github.com/acc-trainings/customer-api-configrepo.git masterconfigyaml'
            sh 'pwd'
            sh '''
            sed "s/%%IMG_TAG%%/${SNP_IMG_TAG}/g" "${WORKSPACE}/Deployment/appdeploy.yaml" > "${WORKSPACE}/masterconfigyaml/appdeploy.yaml"
          
            '''
            dir('masterconfigyaml') {
            sh '''
            git init
            git config --global user.email "acctrainings3@gmail.com"
            git config --global user.name "acctrainings3"
            '''
            sh 'ls'
            sh 'pwd'
            sh 'git add appdeploy.yaml'
            sh '''
            git commit -am "adding latest appdeploy.yaml file to config repo"
            git push https://${username}:${password}@github.com/acc-trainings/customer-api-configrepo.git --all
            '''
            }
    }
    }
    }   
    }   
    
    stage('CleanWorkspaceEnd') {
            steps {
                deleteDir()
            }
        }
    
    
}
}
