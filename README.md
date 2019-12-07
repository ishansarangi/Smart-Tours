# Smart-Tours (Semantic Web)

In   this   project   we are using   semantic   technologies   for making and  linking  from  different data  sources  available  in different locations.

The datasets are modified from the datasets at [![DOI](https://zenodo.org/badge/doi/10.5281/zenodo.3466137.svg)](http://dx.doi.org/10.5281/zenodo.3466137)

## Setup
#### Cleaning
- clone the repo
- run -> npm install in the root directory
- run -> node artist_parser.js
- run -> node artwork_parser.js
- run -> node beacon_generator.js
- verify the respective csv file generated.

#### Setting up the EC2 instance. 
- Install Java
 ``` 
 sudo apt-get install default-jre
 ```
- Create a fuseki user 
 ```
 sudo adduser --disabled-password fuseki
 cd /home/fuseki
 sudo su - fuseki
 wget https://archive.apache.org/dist/jena/binaries/apache-jena-fuseki-2.5.0.tar.gz
 tar xzf apache-jena-fuseki-2.5.0.tar.gz
 ln -s apache-jena-fuseki-2.5.0 fuseki
 cd fuseki 
 exit
 ```

- Setup Fuseki as service. Edit the the file. 
 ```
 $ sudo vim /etc/default/fuseki
 ```
- Add the following to /etc/default/fuseki file.

 `FUSEKI_HOME=/home/fuseki/fuseki`  
 `FUSEKI_BASE=/etc/fuseki`

 ```
 $ sudo mkdir /etc/fuseki
 $ sudo chown fuseki /etc/fuseki
 $ sudo cp /home/fuseki/fuseki/fuseki /etc/init.d/
 $ sudo update-rc.d fuseki defaults
 ```

- Edit the `shiro.ini` configuration file. 
```
$ sudo vim  /etc/fuseki/shiro.ini
```

 comment the line: `/$/** = localhostFilter`
 
 uncomment the line: `/$/** = anon`


#### iOS App
- Open .xcworkspace file present in `Smart-Tours/iOS app/SmartTour/` in xcode.
- hit RUN or cmd+R to run the project.
Note: Requires Xcode 11 (in Mac or MacOS installed in VM)


## Video link
- phase 2: https://youtu.be/DOppe6Q_vK0
- phase 3: https://drive.google.com/open?id=1hr02qdARoiPwVtoWdiGAkTm3YBOEYLmU
- phase 4: https://drive.google.com/open?id=1Sg3gDl4GMogOsIsLMpK_TZ_CVJuz1U7o

## Note
These datasets are modified from the original datasets taken from The Museum of Modern Art (MoMA) Collection.
