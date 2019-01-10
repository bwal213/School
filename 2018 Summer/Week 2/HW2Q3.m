t = 0.01:0.001:1;       % time scale
f = 10;                 % frequency
A = 2;                  % amplitude
w = 2*pi*f;             % frequency transform
b = 0.1*cos(20*pi*t);
c = 0.5*cos((40*pi*t) + (pi/5));
d = 0.7*cos((60*pi*t) + (pi/8));
e = 0.2*cos((80*pi*t) + (pi/3));
y = -0.3 + b + c + d + e;
figure(1);
plot(t,y);