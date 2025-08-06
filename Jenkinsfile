pipeline {
    agent any
   parameters 
   {
 		 string defaultValue: 'main', name: 'branch_name', trim: true
    }
    stages {
		stage('Run Batch Script'){
			steps{
						bat '''ping www.google.com -n 5
								dir
								cd
								netstat -a -n
							'''
			}
		}
        stage('Build') {
            steps {
		try{
                // Get some code from a GitHub repository
                git branch: "${params.branch_name}", url: 'https://github.com/sudheermca51/mmp_care_track.git'

                dir('mmp') {
                         // To run Maven on a Windows agent, use
                         bat "mvn -Dmaven.test.failure.ignore=true clean test"
                }
            }
	    catch (err) {
                        echo "care track mmp job failed"
                        echo "Caught: ${err}"
                    }
	  }
        }
    }
}
