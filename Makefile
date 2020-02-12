build:
	javac *.java
run:
	 java Main $(COMANDA) $(IN1) $(IN2) $(OUT)
clean:
	rm -r *.class