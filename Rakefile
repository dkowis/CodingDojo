require 'erb'
require 'fileutils'

desc "Create a new scala project"
task :new, :name do |t, args|
  root = File.dirname(__FILE__)
  template_dir = File.join(root, "template")

  project_dir = File.join(root, args[:name])
  FileUtils.mkdir project_dir
  FileUtils.cp_r(File.join(template_dir, "project"), project_dir)

  #template in the project file
  erb = ERB.new(File.read(File.join(template_dir, "build.sbt.erb")))
  @name = args[:name]
  File.open(File.join(project_dir, "build.sbt"), 'w') do |file|
    file.write erb.result(binding)
  end

  # go ahead and make the source dirs for idea
  FileUtils.mkdir_p File.join(project_dir, "src","main","scala")
  FileUtils.mkdir_p File.join(project_dir, "src","test","scala")
end
