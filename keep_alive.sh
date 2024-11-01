#!/bin/bash

docker update --restart always Time_Api_App

echo "Restart policy set to 'always' for Time_Api_App container."