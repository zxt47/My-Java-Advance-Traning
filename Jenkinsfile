pipeline {
   agent any
   stages {
           stage('Build') {
               steps {
                   sh '''
                    echo "WorkSpace:${WORKSPACE}"
                   '''
               }
           }
           stage('UnitTest') {
               steps {

                   sh '''
                   echo "========executing UT========"
                   echo "---------执行单元测试----------"
                   mvn clean test
                   '''
               }
           }
       }
}
