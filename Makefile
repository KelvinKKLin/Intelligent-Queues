all: classes run

run: $(classes)
	echo "#!/bin/bash" > run.sh
	echo "java control/Main" >> run.sh
	chmod 754 run.sh 

classes:
	javac control/*.java
	javac objects/*.java

clean:
	rm control/*.class
	rm objects/*.class
	rm *.sh
