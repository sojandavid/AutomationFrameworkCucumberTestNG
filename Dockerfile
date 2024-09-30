# Base image with Maven and OpenJDK 17
FROM maven:3.8.5-openjdk-17-slim

RUN apt-get update && apt-get install -y git

# Install Chromium and ChromeDriver
RUN apt-get update && apt-get install -y \
    chromium \
    chromium-driver \
    && rm -rf /var/lib/apt/lists/*

# Set the display port to avoid crashes
#ENV DISPLAY=:99

# Set working directory
WORKDIR /app

RUN git clone --branch dockerjenkins https://github.com/sojandavid/AutomationFrameworkCucumberTestNG.git .

# Copy your project files to the container
COPY . .

# Run Maven clean and test command
RUN mvn clean test -U

# Start Xvfb before running Selenium tests
#CMD Xvfb :99 -screen 0 1920x1080x16 & mvn test