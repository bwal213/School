T=100;                  %Transmitted power in watts
TdB = 10*log10(1000*T)  %Transmitted power in dBm
for d=1:1:100
    FSPL(d)=(4*pi*d*700*10^6/(3*10^8))^2;
    FSPLdB(d)=10*log10(FSPL(d));
    Pr(d)=TdB-FSPLdB(d);
end
figure
plot(FSPLdB)
hold on
plot(Pr)