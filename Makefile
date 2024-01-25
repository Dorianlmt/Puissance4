default: run

compile:
	cd .\src\ && javac Puissance4.java TerminalClear.java && java Puissance4 TerminalClear
#java Puissance4 TerminalClear

run: compile
#java Puissance4 TerminalClear

clean:
	del .\src\*.class 
#Si vous êtes sur Windows il faut laisser le clean tel quel.
#Pour Linux ou Mac remplacer del par rm