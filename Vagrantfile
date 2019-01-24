Vagrant.configure("2") do |config|
	config.vm.box = "ubuntu/xenial64"  
	config.vm.provision "docker" do |d|
		d.run "hello-world"
	end
	config.vm.provision "shell", path: "vagrant-install-docker-compose.sh"
	config.vm.provision "shell", inline: "docker-compose -f /vagrant/docker-compose.yml up"
	config.vm.network "private_network", ip: "172.28.128.3"
end
