chmod 400 work_mac_os.cer
echo "Creating SSH connectionto aws instance"
ssh -i work_mac_os.cer ec2-user@ec2-3-91-202-80.compute-1.amazonaws.com
