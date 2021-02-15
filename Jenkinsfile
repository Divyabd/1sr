pipeline{
  agent  any
  stages {
    stage('MavenVertion'){
      steps{
        echo 'Maven Vaersion'
        sh 'mvn -version'
       
      }
     }
    stage('Clean'){
      steps{
        echo 'Clean'
        sh 'mvn clean'
       
      }
     }
    stage('Compile'){
      steps{
        echo 'Compile'
        sh 'mvn compile'
        
      }
     }
    stage('package'){
      steps{
        echo 'Packing '
        sh 'mvn -B -DskipTests clean package'
        
      }
     }
    stage('Test'){
      steps{
        echo 'Maven test'
        sh 'mvn test'
      }
      
  }
  }
}
