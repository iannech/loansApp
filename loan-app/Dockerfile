FROM node:8

# Create an app directory (in the Docker container)
WORKDIR /loan-app

# Copy package.json into container
COPY package*.json ./

# and install dependencies
RUN npm cache clean --force && npm install

# copy app source to image _after_ npm install so that
# application code changes don't bust the docker cache of npm install step
COPY . /loan-app

# set application PORT 
EXPOSE 3000

# Finally start the container command
CMD [ "npm", "run", "start" ]
