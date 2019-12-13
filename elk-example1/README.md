# elk-example
mvn clean package <br/>
docker build --tag=elk-example . <br/>
docker run elk-example <br/>
docker rmi elk-example -f <br/>
docker image ls <br/>
docker image rm <IMAGE_ID> <br/>
docker container ls <br/>
docker container rm <CONATINER_ID> <br/>
<br/>
<br/>
<hr/><br/>
docker-compose build

# Disable Experimental Features
disabling "Experimental Features" in the Settings/Daemon menu<br/>
restarting docker<br/>
stopping all containers.<br/>
To stop all containers, run: docker ps -a -q | ForEach { docker stop $_ }<br/>

# Run elasticsearch
docker run -d --name elasticsearch --net bridge -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.4.0

