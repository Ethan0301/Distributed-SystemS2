# Assignment 1 — Java RMI Calculator (README)
Directory
- Users/desktop/Distributed_System/Assignment1

Files
- Calculator.java
- CalculatorImplementation.java
- CalculatorServer.java
- CalculatorClient.java

Compile
- cd Users/desktop/Distributed_System/Assignment1
- javac *.java

Run (recommended: server starts registry internally)
- Terminal 1:
  - cd Users/desktop/Distributed_System/Assignment1
  - java CalculatorServer
- Terminal 2:
  - cd Users/desktop/Distributed_System/Assignment1
  - java CalculatorClient

Multiple clients
- In Assignment1 directory:
  - for i in 1 2 3; do java CalculatorClient & done; wait

Expected output
- Client connects: [Client] Connected to: Calculator
- Single-thread results: min=3, max=55, lcm=24, gcd=6, delayPop=42
- Concurrent demo: logs from T1/T2/T3 (occasional empty-stack errors are expected in stress test)

Troubleshooting
- Could not find or load main class:
  - Ensure you are in Distributed_System/Assignment1 and run: javac *.java
- Name not bound: Calculator:
  - Start the server first; ensure bind/lookup name is "Calculator"
- Port 1099 already in use:
  - pkill -f rmiregistry; pkill -f CalculatorServer (then rerun the server)
