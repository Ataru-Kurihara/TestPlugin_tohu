TODAY=$(shell date +%Y%m%d)

copy:
	copy .\target\test-1.0-SNAPSHOT.jar ..\to-hu-mohist-server\data\plugins\test-plugin-1.0-SNAPSHOT.jar