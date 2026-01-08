pipeline {
   agent any
   stages {
     stage('git repo & clean') {
       step {
        // bat "rmdir /s /q UiBddAutomationFramework"
         bat "git clone https://github.com/adityasingh722/UiBddAutomationFramework.git"
         bat "mvn clean -f UiBddAutomationFramework"
       }
     }
     stage('install') {
       step {
          bat "mvn install -f UiBddAutomationFramework"
       }
     }
     stage('test') {
       step {
          bat "mvn test -f UiBddAutomationFramework"
       }
     }
     stage('package') {
       step {
          bat "mvn package -f UiBddAutomationFramework"
       }
     }
   }

}

