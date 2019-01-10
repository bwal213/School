t = 0.01:0.001:1;       % time scale
f = 10;                 % frequency
A = 2;                  % amplitude
w = 2*pi*f;             % frequency transform
y = A*cos(w*t).^2;         % basic cosine signal
figure(1);
plot(t,y);