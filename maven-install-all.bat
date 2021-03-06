@SET OUTPUT_FILE=maven-install-output.txt

@ECHO ON
CALL maven-install-single.bat drumbeat-common 1> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.common 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.data 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-rdf 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-rdf.modelfactory 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.convert.stff2ifc 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.processing.grounding.ifc 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.convert.ifc2ld 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.convert.ifc2ld.cli 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-ifc.convert.ifc2ld.web 1>> %OUTPUT_FILE%

@ECHO ON
CALL maven-install-single.bat drumbeat-test 1>> %OUTPUT_FILE%

@PAUSE


