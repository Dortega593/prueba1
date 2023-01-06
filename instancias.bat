cd .\build\install\prueba1

start java -Dserver.port=8081 -classpath lib/* com.distribuida.Servidor & start java -Dserver.port=8082 -classpath lib/* com.distribuida.Servidor & start java -Dserver.port=8083 -classpath lib/* com.distribuida.Servidor & start java -Dserver.port=8084 -classpath lib/* com.distribuida.Servidor