#!/bin/bash

while true; do
    if [ "$(docker ps -q -f name=time_api_app)" ]; then
        echo "Container is running"
    else
        echo "Container is not running, restarting..."
        docker start time_api_app
    fi
    sleep 60
done