#1
mkdir beautifly3
touch froslass6
echo "Тип покемона ICE GHOST" > froslass6
touch garchomp8
echo "satk=8 sdef=9 \nspd=10" > garchomp8
touch happiny1
echo "Способности Last Chance Natural Cure Serene Grace" > happiny1
mkdir rhydon0
mkdir teddiursa5

cd beautifly3
touch alakazam
echo "Способности Mind Mold Synchronize Inner \nFocus" > alakazam
mkdir lillipup
mkdir politoed
touch darmanitan
echo "Развитые способности Zen Mode" > darmanitan
touch umbreon
echo "Тип покемона \nDARK NONE" > umbreon

cd .. 

cd rhydon0
mkdir vibrava
mkdir dusclops
mkdir glameow

cd .. 

cd teddiursa5
mkdir deino
mkdir rampardos
mkdir venipede

cd .. 
tree

#2
chmod 524 beautifly3 
chmod 004 beautifly3/alakazam
chmod 752 beautifly3/lillipup
chmod 737 beautifly3/politoed
chmod 400 beautifly3/darmanitan
chmod 400 beautifly3/umbreon
chmod 404 froslass6
chmod 640 garchomp8
chmod 444 happiny1
chmod 500 rhydon0
chmod 737 rhydon0/vibrava
chmod 335 rhydon0/dusclops
chmod 550 rhydon0/glameow
chmod 537 teddiursa5
chmod 500 teddiursa5/deino
chmod 777 teddiursa5/rampardos
chmod 752 teddiursa5/venipede

#3
ln -s rhydon0 Copy_10
cp froslass6 beautifly3/alakazamfroslass
ln -s garchomp8 beautifly3/alakazamgarchomp
cat beautifly3/umbreon beautifly3/umbreon > froslass6_98
cp froslass6 beautifly3/lillipup
ln -h happiny1 beautifly3/umbreonhappiny
cp teddiursa5 teddiursa5/deino/

#4
wc teddiursa5/*
ls -R | grep *s | head -n 3 | sort -s
cat happiny1 | grep -v -i Mo
ls -R | sort -sr 2>/dev/null
ls -R -tcr | grep ^d | tail -n 2
cat -b  beautifly3/alakazam beautifly3/darmanitan | grep -v e$

#5
rm garchomp8
rm beautifly3/umbreon
rm Copy_*
rm beautifly3/umbreonhappi*
rmdir beautifly3
rmdir rhydon0/dusclops