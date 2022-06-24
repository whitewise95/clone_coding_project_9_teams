REPOSITORY1=/home/ubuntu
REPOSITORY=/home/ubuntu/spart
PROJECT_NAME=clone_coding_project_9_teams-0.0.1-SNAPSHOT.jar

echo 
CURRENT_PID=$(pgrep -fl $PROJECT_NAME | grep java | awk '{print $1}')

if [ -z $CURRENT_PID ]; then
    echo 
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo 
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo 
chmod +x $JAR_NAME

echo 
nohup java -jar $JAR_NAME > $REPOSITORY1/nohup.out 2>&1 &
