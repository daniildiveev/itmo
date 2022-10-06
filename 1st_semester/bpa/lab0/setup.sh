#!/bin/bash

#1
mkdir -p beautifly3/{lillipup,politoed}
touch beautifly3/{alakazam,darmanitan,umbreon}
touch froslass6
touch garchomp8
touch happiny1
mkdir -p rhydon0/{vibrava,dusclops,glameow}
mkdir -p teddiursa5/{deino,rampardos,venipede}

echo "Тип покемона ICE GHOST" > froslass6
echo -e "satk=8 sdef=9 \nspd=10" > garchomp8
echo "Способности Last Chance Natural Cure Serene Grace" > happiny1
echo -e "Способности Mind Mold Synchronize Inner \nFocus" > beautifly3/alakazam
echo "Развитые способности Zen Mode" > beautifly3/darmanitan
echo -e "Тип покемона \nDARK NONE" > beautifly3/umbreon

ls -lR

echo "-----------------------------------------------"

#2
chmod 524 beautifly3 
chmod u=---,g=---,o=r-- beautifly3/alakazam
chmod rwxr-x-w- beautifly3/lillipup
chmod 737 beautifly3/politoed
chmod u=r--,g=---,o=--- beautifly3/darmanitan
chmod r-------- beautifly3/umbreon
chmod 404 froslass6
chmod u=rw-,g=r--,o=--- garchomp8
chmod r--r--r-- happiny1
chmod 500 rhydon0
chmod u=rwx,g=-wx,o=rwx rhydon0/vibrava
chmod -wx-wxr-x rhydon0/dusclops
chmod 550 rhydon0/glameow
chmod u=r-x,g=-wx,o=rwx teddiursa5
chmod r-x------ teddiursa5/deino
chmod 777 teddiursa5/rampardos
chmod u=rwx,g=r-x,o=-w- teddiursa5/venipede

ls -lR

echo "-----------------------------------------------"

#3
ln -s rhydon0 Copy_10
cp froslass6 beautifly3/alakazamfroslass
ln -s ../garchomp8 beautifly3/alakazamgarchomp
cat beautifly3/umbreon beautifly3/umbreon > froslass6_98
cp froslass6 beautifly3/lillipup
ln -h happiny1 beautifly3/umbreonhappiny
cp teddiursa5 teddiursa5/deino/

ls -lR

echo "-----------------------------------------------"

#4
wc -m teddiursa5/* 2>&1 | sort -k1
ls -lR 2>&1 | grep ^- | grep s$ | head -n 3 | sort -s
cat happiny1 2>&1 | grep -vi Mo 
ls -Rl teddiursa5/ 2>/dev/null | grep ^- | sort -sr
ls -Rltcr 2>&1 | grep ^- | sort -k6 | grep "^.\{44\}d"
cat -b beautifly3/alakazam beautifly3/darmanitan 2>/dev/null | grep -vi e$

echo "-----------------------------------------------"

#5
rm garchomp8
rm beautifly3/umbreon
rm Copy_*
rm beautifly3/umbreonhappi*
rm -rf beautifly3
rmdir rhydon0/dusclops

ls -R