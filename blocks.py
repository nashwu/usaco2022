test_cases = int(input())

cubes=[]
for dummy in range(4):
    block_letters=input()
    block_letter_list=[c for c in block_letters]
    cubes.append(sorted(set(block_letter_list)))

for dummy in range(test_cases):
    occupied=[]
    yes=0
    w=input()
    w_letter=[c for c in w]
    w_l=len(w)
    letter=[{} for d in range(w_l)]
    w_n=0
    for c in w_letter:
        letter[w_n]['Cube_collection']=[]
        letter[w_n]['Block_appearance']=0
        b_count=0
        b_id=0
        for bc in cubes:
            if c in bc:
                b_count=b_count+1
                letter[w_n]['Cube_collection'].append(b_id)
                letter[w_n]['Block_appearance']=b_count
            b_id=b_id+1
        w_n=w_n+1

    makeup=sorted(letter,key=lambda x: x['Block_appearance'])

    if w_l == 1:
        if makeup[0]['Block_appearance']>=w_l:
            occupied.append(makeup[0]['Cube_collection'])

    if w_l == 2:
        for x in makeup[0]['Cube_collection']:
            temp_list0=[x]
            for y in makeup[1]['Cube_collection']:
                temp_list1=temp_list0
                if not y in temp_list1:
                    temp_list1.append(y)
                occupied.append(temp_list1)

    if w_l == 3:
        for x in makeup[0]['Cube_collection']:
            temp_list0=[x]
            for y in makeup[1]['Cube_collection']:
                temp_list1=temp_list0
                if not y in temp_list1:
                    temp_list1.append(y)
                for z in makeup[2]['Cube_collection']:
                    temp_list2=temp_list1
                    if not z in temp_list2:
                        temp_list2.append(z)
                    occupied.append(temp_list2)

    if w_l == 4:
        for x in makeup[0]['Cube_collection']:
            temp_list0=[x]
            for y in makeup[1]['Cube_collection']:
                temp_list1=temp_list0
                if not y in temp_list1:
                    temp_list1.append(y)
                for z in makeup[2]['Cube_collection']:
                    temp_list2=temp_list1
                    if not z in temp_list2:
                        temp_list2.append(z)
                    for w in makeup[3]['Cube_collection']:
                        temp_list3=temp_list2
                        if not w in temp_list3:
                            temp_list3.append(w)
                        occupied.append(temp_list3)

    for supply in occupied:
        if len(supply)>=w_l:
            yes=1
    if yes==1:
        print('YES')
    else:
        print('NO')

