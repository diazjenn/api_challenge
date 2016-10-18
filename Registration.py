import json
import urllib.request as ULReq

HTTP = 'http://challenge.code2040.org/api/register'
regInfor = {'token': '24e5804d1332a3ae387923c1de783b61', \
			'github': 'https://github.com/darthfrazier/API-Challenge'}
data = json.dumps(regInfor).encode('utf-8')
headers = {'content-type': 'application/json', 'User-Agent' : 'user_agent'}
request = ULReq.Request(HTTP, data=data, headers=headers)
response = ULReq.urlopen(request)
readResponse = response.read().decode('utf-8')
print(readResponse)
