pipeline {
   agent any
   stages {
     stage('git repo & clean') {
       steps {
        // bat "rmdir /s /q UiBddAutomationFramework"
         bat "git clone https://github.com/adityasingh722/UiBddAutomationFramework.git"
         bat "mvn clean -f UiBddAutomationFramework"
       }
     }
     stage('install') {
       steps {
          bat "mvn install -f UiBddAutomationFramework"
       }
     }
     stage('test') {
       steps {
          bat "mvn test -f UiBddAutomationFramework"
       }
     }
     stage('package') {
       steps {
          bat "mvn package -f UiBddAutomationFramework"
       }
     }
   }

}


