# TesteNeogrid
Desafio de leitura e manipulação de arquivo

Desafio :
Problem Statement - Assembly Line

We need to adjust our assembly lines using the below constraints.
there are so many possibilities, you should write a program to organize this production.

Constraints:
- Don't use plugins utilities or frameworks for date calculations (e.g. Joda-Time)
- Use input.txt as the system input data file.
- The production has multiple assembly lines and each one has the morning, lunch and afternoon periods.
- Each period has multiple steps of the production process. Obviously the lunch period doesn't have them.
- The morning period begins at 9:00 am and must finish by 12:00 noon, for lunch.
- The afternoon period begins at 1:00 pm and must finish in time for the labor gymnastics activities.
- The labor gymnastics activities can start no earlier than 4:00 pm and no later than 5:00 pm.
- The production step titles don't have numbers in it.
- All the numbers in the production step titles are the step time in minutes or the word "maintenance" which one represents a 5 minutes of technical pause.
- It won't have interval between the process steps

Depending on how you choose to solve this issue the output may give a different ordering or combination of the process steps into the assembly lines. This is acceptable, there aren't a required order of them and the steps can be distributed into any assembly line. 
You don’t need to exactly produce the sample output given here, but you need to consider the constraints!

Different data inputs will be used to test you program besides the example below and it can produce N assembly lines.



Test data (input.txt)
------------------------------------------------------------

Cutting of steel sheets 60min
Austenpera (Heat treatment) 30min
Tempering sub-zero (Heat treatment) 45min
Safety sensor assembly 60min
Pieces washing 45min
Axis calibration 30min
Steel bearing assembly 45min
Assembly line cooling - maintenance
Nitriding process 45min
Injection subsystem assembly 60min
Compliance check 30min
Navigation subsystem assembly 60min
Torque converter subsystem calibration 60min
Left stabilizer bar alignment 30min
Setup of lock and control device 45min
Right stabilizer bar alignment 30min
Seal installation 45min
Application of decals 30min
Monitoring subsystem assembly 30min



Output example
------------------------------------------------------------

Linha de montagem 1:
09:00 Cutting of steel sheets 60min
10:00 Injection subsystem assembly 60min
11:00 Navigation subsystem assembly 60min
12:00 Almoço
13:00 Torque converter subsystem calibration 60min
14:00 Steel bearing assembly 45min
14:45 Nitriding process 45min
15:30 Setup of lock and control device 45min
16:15 Compliance check 30min
16:45 Esfriamento da linha manutenção
16:50 Ginástica laboral

Linha de montagem 2:
09:00 Safety sensor assembly 60min
10:00 Tempering sub-zero (Heat treatment) 45min
10:45 Pieces washing 45min
11:30 Right stabilizer bar alignment 30min
12:00 Almoço
13:00 Seal installation 45min
13:45 Left stabilizer bar alignment 30min
14:15 Monitoring subsystem assembly 30min
14:45 Application of decals 30min
15:15 Axis calibration 30min
15:45 Austenpera (Heat treatment) 30min
16:15 Ginástica laboral
