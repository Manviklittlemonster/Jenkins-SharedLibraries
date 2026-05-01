def call(String Project, String ImageTag, String DockerHubUser, String ContainerName, String PortMapping){
    // Remove old container if it exists
    sh """
        docker rm -f ${ContainerName} || true
    """

    // Run new container from the specified image
    sh """
        docker run -d --name ${ContainerName} -p ${PortMapping} ${DockerHubUser}/${Project}:${ImageTag}
    """
}
